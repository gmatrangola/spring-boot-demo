package com.matrangola.springbootdemo.data.model;

import javax.persistence.*;

@Entity
@Table(name = "gadget")
public class Gadget {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "is_on")
    private boolean on;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable = false)
    private User owner;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
