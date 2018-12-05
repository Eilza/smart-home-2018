package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.Door;

public class HallDoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) return;
        // событие от двери
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName() == "hall") {
                    smartHome.executeHomeGoRoundFunctional(object1 -> {
                        if (object1 instanceof Light) {
                            Light light = (Light) object1;
                            light.changeState(light.getId(), false);
                        }
                    });
                    System.out.println("Hall door was closed. All lights off");
                }
            }
        });
    }
}
