package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SmartHome;

public class DoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;
        // событие от двери
        smartHome.executeHomeGoRoundFunctional( object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                boolean state = event.getType() == DOOR_OPEN;
                door.changeState(event.getObjectId(), state);
            }
        });
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
    private class DoorHomeGoRoundFunctional implements HomeGoRoundFunctional {
        @Override
        public void execute(Object object) {
        }
    }
}