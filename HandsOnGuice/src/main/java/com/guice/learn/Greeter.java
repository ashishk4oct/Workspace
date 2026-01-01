package com.guice.learn;

import com.google.inject.Inject;

import java.util.*;

public class Greeter {
    private final String message;
    private final int count;

    // Greeter declares that it needs a string message and an integer
    // representing the number of time the message to be printed.
    // The @Inject annotation marks this constructor as eligible to be used by
    // Guice.
    @Inject
    private Greeter(@Message String message, @Count int count) {
        this.message = message;
        this.count = count;
    }

    public void sayHello() {
        System.out.println(this);
        for (int i=0; i < count; i++) {
            System.out.println(message);
        }
    }
    @interface Message {
    }

}