package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;
<<<<<<< HEAD
import ru.sbt.mipt.oop.SensorEvent;

public class LightsEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public LightsEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
=======

public class LightsEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
        if (!isLightEvent(event)) return;
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof  Light) {
                Light light = (Light) object;
<<<<<<< HEAD
                boolean state = event.getType().equals(LIGHT_ON);
=======
                boolean state = event.getType() == LIGHT_ON;
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
                light.changeState(event.getObjectId(), state);
            }
        });
    }

    private boolean isLightEvent(SensorEvent event) {
        if (event == null) return false;
        return event.getType().equals(LIGHT_ON) || event.getType().equals(LIGHT_OFF);
    }
}
