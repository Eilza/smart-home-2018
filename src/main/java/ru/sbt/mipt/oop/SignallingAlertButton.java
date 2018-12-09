package ru.sbt.mipt.oop;

public class SignallingAlertButton implements RemoteButtons{
    private final SmartHomeSource smartHome;

    public SignallingAlertButton(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getSignaling().setToAlert();
    }
}
