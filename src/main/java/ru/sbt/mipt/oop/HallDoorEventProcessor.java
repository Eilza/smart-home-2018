package ru.sbt.mipt.oop;
<<<<<<< HEAD

public class HallDoorEventProcessor implements EventProcessor {
    private final SmartHomeSource smartHome;

    public HallDoorEventProcessor(SmartHomeSource smartHome) {
        this.smartHome = smartHome;
    }
=======
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.Door;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.Light;

public class HallDoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
<<<<<<< HEAD
=======
=======

public class HallDoorEventProcessor implements EventProcessor {
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618

    @Override
    public void processEvent(SensorEvent event) {
        if (!event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            return;
        }
        // событие от двери
        smartHome.executeHomeGoRoundFunctional(object -> {
<<<<<<< HEAD
            if (object instanceof RoomComponent) {
                RoomComponent room = (RoomComponent) object;
                if (room.getName().equals("hall")) {
                    new AllLightOffButton(smartHome).execute();
                    System.out.println("Hall door was closed. All light is off");
=======
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    smartHome.executeHomeGoRoundFunctional(object1 -> {
                        if (object1 instanceof Light) {
                            Light light = (Light) object1;
                            light.changeState(light.getId(), false);
                        }
                    });
                    System.out.println("Hall door was closed. All lights off");
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
                }
            }
        });
    }
}
