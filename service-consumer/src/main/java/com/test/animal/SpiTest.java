package com.test.animal;

import com.provider.intf.Animal;

import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        load.forEach(Animal::call);

    }
}
