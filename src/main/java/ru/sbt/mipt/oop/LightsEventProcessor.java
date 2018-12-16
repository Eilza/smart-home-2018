package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

public class LightsEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public LightsEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (!isLightEvent(event)) return;
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof  Light) {
                Light light = (Light) object;
                boolean state = event.getType().equals(LIGHT_ON);
                light.changeState(event.getObjectId(), state);
            }
        });
    }

    private boolean isLightEvent(SensorEvent event) {
        if (event == null) return false;
        return event.getType().equals(LIGHT_ON) || event.getType().equals(LIGHT_OFF);
    }
}
