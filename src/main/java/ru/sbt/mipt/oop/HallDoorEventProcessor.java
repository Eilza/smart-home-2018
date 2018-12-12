package ru.sbt.mipt.oop;

public class HallDoorEventProcessor implements EventProcessor {
    private final SmartHomeSource smartHome;

    public HallDoorEventProcessor(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (!event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            return;
        }
        // событие от двери
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof RoomComponent) {
                RoomComponent room = (RoomComponent) object;
                if (room.getName().equals("hall")) {
                    new AllLightOffButton(smartHome).execute();
                    System.out.println("Hall door was closed. All light is off");
                }
            }
        });
    }
}
