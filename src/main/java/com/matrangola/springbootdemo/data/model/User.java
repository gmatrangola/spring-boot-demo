package com.matrangola.springbootdemo.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,  property = "id")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date birthday;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Gadget> gadgets;

    public User() {
        // for JPA
    }

    public User(String first, String last, Date birthday) {
        this.firstName = first;
        this.lastName = last;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Gadget> getGadgets() {
        return gadgets;
    }
}
