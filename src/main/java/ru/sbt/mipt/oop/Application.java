package ru.sbt.mipt.oop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class Application {
    public static void main(String... args)  throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Combinator.class);
        EventManager eventManager = context.getBean(EventManager.class);
        eventManager.runEventLoop();

    }
}