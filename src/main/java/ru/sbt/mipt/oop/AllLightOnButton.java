package ru.sbt.mipt.oop;

public class AllLightOnButton implements RemoteButtons {
    private final SmartHomeSource smartHome;

    public AllLightOnButton(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional(object1 -> {
            if (object1 instanceof LightComponent) {
                LightComponent light = (LightComponent) object1;
                light.changeState(light.getId(), true);
            }
        });
    }
}