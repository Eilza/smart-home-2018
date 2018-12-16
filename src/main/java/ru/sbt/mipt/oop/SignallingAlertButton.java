package ru.sbt.mipt.oop;

public class SignallingAlertButton implements RemoteButtons{
    private final SmartHome smartHome;

    public SignallingAlertButton(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getSignaling().setToAlert();
    }
}
