package com.matrangola.springbootdemo.data.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.matrangola.springbootdemo.data.seralization.ColorDeseralizer;
import com.matrangola.springbootdemo.data.seralization.ColorSerializer;

import javax.persistence.*;

@Entity
@Table(name = "color")
@JsonSerialize(using = ColorSerializer.class)
@JsonDeserialize(using = ColorDeseralizer.class)
public class Color {
    @Id
    @GeneratedValue
    long id;

    @Column
    int red;
    @Column
    int green;
    @Column
    int blue;

    public long getId() {
        return id;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
