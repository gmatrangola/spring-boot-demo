package com.matrangola.springbootdemo.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date birthday;

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
}
