package com.platform.web.configuration;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
@ComponentScan(basePackages = { "com.platform.web.controller",
        "com.platform.web.dao" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
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

    @Bean(name = "userDAO")
    @Autowired
    public GenericDAO<User> getUserDao(SessionFactory sessionFactory) {
        return new GenericDAOImpl<User>(sessionFactory, User.class);
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
