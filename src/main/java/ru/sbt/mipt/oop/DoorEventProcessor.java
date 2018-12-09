package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SmartHome;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
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
<<<<<<< HEAD
=======
=======

public class DoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;
        // событие от двери
        smartHome.executeHomeGoRoundFunctional( object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                boolean state = event.getType() == DOOR_OPEN;
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
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
<<<<<<< HEAD
=======
    }
    private class DoorHomeGoRoundFunctional implements HomeGoRoundFunctional {
        @Override
        public void execute(Object object) {
        }
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
    }
}