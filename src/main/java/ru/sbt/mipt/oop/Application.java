package ru.sbt.mipt.oop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
<<<<<<< HEAD
import ru.sbt.mipt.oop.EventManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String... args) {
        EventManager eventManager = context.getBean(EventManager.class);
        eventManager.runEventLoop();
=======
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHome;
import java.io.IOException;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public class Application {
    private static SmartHome smartHome;
    private static EventProvider eventProvide;
    private static HomeEventObserver homeEventObserver;

    public Application() throws IOException {
        smartHome = new FileSmartHomeLoader().loadSmartHome();
        eventProvide = new RandomSensorEventProvider();
        homeEventObserver = new HomeEventObserver(eventProvide);
    }

<<<<<<< HEAD
    public static void main(String... args) {
        Combinator.combine(homeEventObserver, smartHome);
=======
    public static void main(String... args) throws IOException {
        Combinator.combine(homeEventObserver);
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
        homeEventObserver.runEventLoop(smartHome);
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
    }
}