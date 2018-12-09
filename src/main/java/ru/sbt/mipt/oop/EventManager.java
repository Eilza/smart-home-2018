package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.EventProcessor;

public interface EventManager {
    void runEventLoop();
    void addEventProcessor(EventProcessor processor);
}
