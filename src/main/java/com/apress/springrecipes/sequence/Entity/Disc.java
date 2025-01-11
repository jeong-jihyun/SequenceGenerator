package com.apress.springrecipes.sequence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Disc extends Product{
    private int capacity;
    public Disc(){

    }

    public Disc(String name, double price) {
        super(name, price);
    }

}
