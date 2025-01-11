package com.apress.springrecipes.sequence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Battery extends Product{
    private boolean rechargable;
    public Battery(){
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

}
