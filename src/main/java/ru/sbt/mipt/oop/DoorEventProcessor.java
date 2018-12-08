package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

public class DoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (!isDoorEvent(event)) return;
        // событие от двери
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                boolean state = event.getType().equals(DOOR_OPEN);
                door.changeState(event.getObjectId(), state);
            }
        });
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType().equals(DOOR_CLOSED) || event.getType().equals(DOOR_OPEN);
    }
    private class DoorHomeGoRoundFunctional implements HomeGoRoundFunctional {
        @Override
        public void execute(Object object) {
        }
    }
}