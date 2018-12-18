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

            if (object instanceof Light) {

                Light light = (Light) object;
                event.toString();
                if (light.getId().equals(event.getObjectId())) {
                    boolean state = event.getType().equals(LIGHT_ON);
                    light.changeState(state);
                }
            }
        });
    }

    private boolean isLightEvent(SensorEvent event) {
        return (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF);
    }
}

