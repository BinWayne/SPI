package com.test.animal;

import com.provider.intf.Animal;

public class Dog implements Animal {
    @Override
    public void call() {
        System.out.println("this is dog call");
    }
}
