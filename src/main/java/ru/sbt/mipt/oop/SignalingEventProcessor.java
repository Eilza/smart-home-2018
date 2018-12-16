package ru.sbt.mipt.oop;

public class SignalingEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public SignalingEventProcessor(SmartHome smartHome) {
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
    }
    private boolean isSignalingEvent(SensorEvent event) {
        return event.getType().equals(SensorEventType.ALARM_ACTIVATE)
                || event.getType().equals(SensorEventType.ALARM_DEACTIVATE);
    }
}
