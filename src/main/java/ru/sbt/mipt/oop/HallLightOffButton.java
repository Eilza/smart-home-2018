package ru.sbt.mipt.oop;

public class HallLightOffButton implements RemoteButtons{
    private final SmartHomeSource smartHome;

    public HallLightOffButton(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional( object ->  {
            if (object instanceof RoomComponent) {
                RoomComponent room = (RoomComponent) object;
                if (room.getName().equals("hall")) {
                    room.executeHomeGoRoundFunctional(object1 -> {
                        if (object1 instanceof LightComponent) {
                            LightComponent light = (LightComponent) object1;
                            light.changeState(light.getId(), true);
                        }
                    });
                }
            }
        });
    }
}
