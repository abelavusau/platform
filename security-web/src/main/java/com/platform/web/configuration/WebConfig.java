package com.platform.web.configuration;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import com.platform.web.dao.generic.GenericDAO;
import com.platform.web.dao.impl.generic.GenericDAOImpl;
import com.platform.web.model.Role;
import com.platform.web.model.User;
import com.platform.web.service.generic.GenericService;
import com.platform.web.service.impl.generic.GenericServiceImpl;

@Configuration
@Import(value = { DbConfig.class, SecurityConfig.class })
@EnableWebMvc
@EnableJms
@ComponentScan(basePackages = { "com.platform.web.controller",
        "com.platform.web.dao", "com.platform.web.jms" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/css/**").addResourceLocations(
	        "/WEB-INF/css/");
	registry.addResourceHandler("/js/**").addResourceLocations(
	        "/WEB-INF/js/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/jsp/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }

    @Bean
    public TilesConfigurer getTilesConfigurer() {
	TilesConfigurer configurer = new TilesConfigurer();
	configurer.setDefinitions("/WEB-INF/tiles/tiles-definitions.xml");
	return configurer;
    }

    // http://shengwangi.blogspot.com/2014/10/spring-jms-with-activemq-helloworld-example-send.html

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	factory.setConnectionFactory(getConnectionFactory());
	factory.setDestinationResolver(getDestinationResolver());
	factory.setPubSubDomain(false);
	factory.setConcurrency("3-10");
	return factory;
    }
    
    @Bean
    public DestinationResolver getDestinationResolver() {
	return new DynamicDestinationResolver();
    }

    @Bean
    public ConnectionFactory getAMQConnectionFactory() {
	return new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
    }

    @Bean
    public ConnectionFactory getConnectionFactory() {
	return new CachingConnectionFactory(getAMQConnectionFactory());
    }

    @Bean
    public Destination getDestination(boolean pubSub) {
	if (pubSub) {
	    return new ActiveMQTopic("myMessageTopic");
	} else {
	    return new ActiveMQQueue("myMessageQueue");
	}
    }

    @Bean
    public JmsTemplate getJmsTemplate() {
	JmsTemplate jmsTemplate = new JmsTemplate();
	jmsTemplate.setConnectionFactory(getConnectionFactory());
	jmsTemplate.setDefaultDestination(getDestination(false));
	jmsTemplate.setPubSubDomain(false);
	return jmsTemplate;
    }

    @Bean(name = "userService")
    @Resource(name = "userDAO")
    public GenericService<User> getUserService(GenericDAO<User> dao) {
	return new GenericServiceImpl<User>(dao);
    }

    @Bean(name = "roleDAO")
    @Autowired
    public GenericDAO<Role> getRoleDAO(SessionFactory sessionFactory) {
	return new GenericDAOImpl<Role>(sessionFactory, Role.class);
    }

    @Bean(name = "roleService")
    @Resource(name = "roleDAO")
    public GenericService<Role> getRoleService(GenericDAO<Role> dao) {
	return new GenericServiceImpl<Role>(dao);
    }
}
