package com.test;

import com.test.interfaces.SimpleInterface;

public class UseSimpleInterface {

    public static void main(String[] args) {
        final SimpleInterface obj = () -> {
            System.out.println("Hello World");
        };
        obj.doSomething();
    }

}
