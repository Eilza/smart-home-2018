package ru.sbt.mipt.oop;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class LightsEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;
        smartHome.executeHomeGoRoundFunctional(object -> {
            if (object instanceof  Light) {
                Light light = (Light) object;
                boolean state = event.getType() == LIGHT_ON;
                light.changeState(event.getObjectId(), state);
            }
        });
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
