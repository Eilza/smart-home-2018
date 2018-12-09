package ru.sbt.mipt.oop;

public class Light {
    private boolean isOn;
    private final String id;
    public boolean isOn() {
        return isOn;
    }
    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }
    public String getId() {
        return id;
    }
}