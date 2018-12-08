package ru.sbt.mipt.oop;

public interface AlertState {
    void changeState( AlertState state);
    void activate(String pass);
    void deactivate(String pass);
    void setToAlert();
}
