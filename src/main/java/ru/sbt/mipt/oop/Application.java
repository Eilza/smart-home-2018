package ru.sbt.mipt.oop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Combinator.class);
        EventManager eventManager = context.getBean(EventManager.class);
        eventManager.runEventLoop();
    }
}