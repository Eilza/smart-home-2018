package ru.sbt.mipt.oop;

public class AllLightOnButton implements RemoteButtons {
    private final SmartHome smartHome;

    public AllLightOnButton(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.changeState(light.getId(), true);
            }
        });
    }
}
