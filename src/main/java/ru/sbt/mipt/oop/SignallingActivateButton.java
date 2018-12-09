package ru.sbt.mipt.oop;

public class SignallingActivateButton implements RemoteButtons{
    private final SmartHomeSource smartHome;

    public SignallingActivateButton(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getSignaling().activate("default");
    }
}
