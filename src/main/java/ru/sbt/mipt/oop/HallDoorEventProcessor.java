package ru.sbt.mipt.oop;

public class HallDoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (!event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            return;
        }
        // событие от двери
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    new AllLightOffButton(smartHome).execute();
                    System.out.println("Hall door was closed. All light is off");
                }
            }
        });
    }
}
