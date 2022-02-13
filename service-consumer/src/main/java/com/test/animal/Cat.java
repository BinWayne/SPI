package com.test.animal;

import com.provider.intf.Animal;

public class Cat implements Animal {
    @Override
    public void call() {
        System.out.println("this is cat call");
    }
}
