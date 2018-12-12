package ru.sbt.mipt.oop;

public interface EventManager {
    void runEventLoop();
    void addEventProcessor(EventProcessor processor);
}
