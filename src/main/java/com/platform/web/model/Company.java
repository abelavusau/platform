package com.platform.web.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "companies", schema = "platform", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Company extends DomainObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CompanyType type;
    private String name;
    private String description;
    private Address address;
    private User user;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    public CompanyType getType() {
        return type;
    }
    
    public void setType(CompanyType type) {
        this.type = type;
    }
    
    @Column
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Embedded
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
