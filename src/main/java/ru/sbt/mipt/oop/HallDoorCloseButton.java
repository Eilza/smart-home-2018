package ru.sbt.mipt.oop;

public class HallDoorCloseButton implements RemoteButtons{
    private final SmartHome smartHome;

    public HallDoorCloseButton(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Room) {
                Room room = (Room)object;
                if (room.getName().equals("hall")) {
                    room.executeHomeGoRoundFunctional(object1 -> {
                        if (object1 instanceof Door) {
                            Door door = (Door) object1;
                            door.changeState(door.getId(), false);
                        }
                    });
                }
            }
        });
    }
}
