package com.guice.learn;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class GreaterDemo {
    public void start() {

    }

    public static void main(String[] args) {
        // Creates an injector that has all the necessary dependencies needed to
        // build a functional server.
        Injector injector = Guice.createInjector(
                new DemoModule()
        );
        // Bootstrap the application by creating an instance of the server then
        // start the server to handle incoming requests.
        injector.getInstance(Greeter.class).sayHello();
        injector.getInstance(Greeter.class).sayHello();
        injector.getInstance(Greeter.class).sayHello();
    }
}