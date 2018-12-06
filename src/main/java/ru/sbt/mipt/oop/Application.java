package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

    public static void main(String... args) throws IOException {
        Combinator.combine(homeEventObserver);
        homeEventObserver.runEventLoop(smartHome);
    }
}