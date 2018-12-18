package ru.sbt.mipt.oop;

public class AllLightOffButton implements RemoteButtons{
    private final SmartHome smartHome;

    public AllLightOffButton(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                // Исправить light.changeState(light.getId(), false);
            }
        });
    }
}
