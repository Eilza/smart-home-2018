package ru.sbt.mipt.oop;

public class SignallingActivateButton implements RemoteButtons{
    private final SmartHome smartHome;

    public SignallingActivateButton(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getSignaling().activate("default");
    }
}
