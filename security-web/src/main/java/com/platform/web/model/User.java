package com.platform.web.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", schema = "platform", uniqueConstraints = { @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "username") })
public class User extends DomainObject {
    /**
     * Default serial uid.
     */
    private static final long serialVersionUID = 1L;

    private String            firstname;
    private String            lastname;
    private String            username;
    private String            password;
    private boolean           enabled;

    private Set<Role>         roles;

    public User(String firstname, String lastname, String username, String password, boolean enabled) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.password = password;
	this.enabled = enabled;
    }

    public User() {
    }

    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", catalog = "platform", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
    public Set<Role> getRoles() {
	if (roles == null) {
	    roles = new HashSet<Role>();
	}
	
	return roles;
    }

    public void setRoles(Set<Role> roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password
	        + ", enabled=" + enabled + ", roles=" + roles + "]";
    }
}
