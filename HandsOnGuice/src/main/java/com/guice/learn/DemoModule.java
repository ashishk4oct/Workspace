package com.guice.learn;

/**
 * Guice module that provides bindings for message and count used in
 * {@link Greeter}.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

class DemoModule extends AbstractModule {
    @Provides
    @Count
    static Integer provideCount() {
        return 3;
    }

    @Provides
    @Message
    static String provideMessage() {
        return "hello world";
    }
}
