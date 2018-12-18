package ru.sbt.mipt.oop;

public class HallLightOffButton implements RemoteButtons{
    private final SmartHome smartHome;

    public HallLightOffButton(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional( object ->  {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeHomeGoRoundFunctional(object1 -> {
                        if (object1 instanceof Light) {
                            Light light = (Light) object1;
                            // Исправить  light.changeState(light.getId(), true);
                        }
                    });
                }
            }
        });
    }
}
