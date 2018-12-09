package ru.sbt.mipt.oop;
<<<<<<< HEAD

public class SignalingEventProcessor implements EventProcessor {
    private final SmartHomeSource smartHome;

    public SignalingEventProcessor(SmartHomeSource smartHome) {
=======
import ru.sbt.mipt.oop.HomeGoRoundFunctional;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.HomeFlap;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class SignalingEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public SignalingEventProcessor(SmartHome smartHome) {
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (!isSignalingEvent(event)) {
            return;
        }
        if(event.getType()== SensorEventType.ALARM_ACTIVATE){
            smartHome.activateSignaling(event.getObjectId());
        } else {
            smartHome.deactivateSignaling(event.getObjectId());
        }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        smartHome.executeHomeGoRoundFunctional(new HomeGoRoundFunctional() {
            @Override
            public void execute(Object object) {
                if(event.getType()== SensorEventType.ALARM_ACTIVATE){
                    smartHome.activateSignaling(event.getObjectId());
                } else {
                    smartHome.deactivateSignaling(event.getObjectId());
                }
                if (object instanceof HomeFlap) {
                    HomeFlap leaf = (HomeFlap) object;
                    leaf.lock(smartHome.isHomeLocked());
                }
            }
        });
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
    }
    private boolean isSignalingEvent(SensorEvent event) {
        return event.getType().equals(SensorEventType.ALARM_ACTIVATE)
                || event.getType().equals(SensorEventType.ALARM_DEACTIVATE);
    }
}
