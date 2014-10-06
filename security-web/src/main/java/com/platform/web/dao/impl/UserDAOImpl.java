package com.platform.web.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.platform.web.dao.UserDAO;
import com.platform.web.dao.impl.generic.GenericDAOImpl;
import com.platform.web.model.User;

@Repository(value = "userDAO")
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
	super(sessionFactory, User.class);
    }

    @Override
    public Long create(User entity) {
	entity.setPassword(encoder.encode(entity.getPassword()));
	return super.create(entity);
    }

    @Override
    public void update(User entity) {
	super.update(entity);
    }
}
