package ru.sbt.mipt.oop;
import java.util.Collection;

public class HallDoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {


        if (event.getType().equals(SensorEventType.DOOR_CLOSED)) return;

        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                if (door.getId().equals(event.getObjectId())) {
                    if (isHallDoor(smartHome, door)) {
                        System.out.println("Hall door closed, turning off all lights in the SmartHome:");
                        turnOffLights(smartHome);
                    }
                }
            }
        });
    }


    private boolean isHallDoor(SmartHome smartHome, Door door) {
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            if (room.getName().equals("hall")) {
                Collection<Door> doors = room.getDoors();
                for (Door door1 : doors) {
                    if (door1.getId().equals(door.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void turnOffLights(SmartHome smartHome) {
        for (Room homeRoom :  smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.changeState(false);
            }
        }
    }
}