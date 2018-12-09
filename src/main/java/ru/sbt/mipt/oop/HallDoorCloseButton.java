package ru.sbt.mipt.oop;

public class HallDoorCloseButton implements RemoteButtons{
    private final SmartHomeSource smartHome;

    public HallDoorCloseButton(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof RoomComponent) {
                RoomComponent room = (RoomComponent)object;
                if (room.getName().equals("hall")) {
                    room.executeHomeGoRoundFunctional(object1 -> {
                        if (object1 instanceof DoorComponent) {
                            DoorComponent door = (DoorComponent) object1;
                            door.changeState(door.getId(), false);
                        }
                    });
                }
            }
        });
    }
}
