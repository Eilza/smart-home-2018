package ru.sbt.mipt.oop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.EventManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String... args) {
        EventManager eventManager = context.getBean(EventManager.class);
        eventManager.runEventLoop();
    }
}