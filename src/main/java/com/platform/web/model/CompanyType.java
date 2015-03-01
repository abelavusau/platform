package com.platform.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "company_type", schema = "platform", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class CompanyType extends DomainObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;

    @Column(name = "name", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
