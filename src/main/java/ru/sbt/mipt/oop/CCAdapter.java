package ru.sbt.mipt.oop;
import com.coolcompany.CCSensorEvent;
import com.coolcompany.EventHandler;
import java.util.HashMap;
import java.util.Map;

public class CCAdapter implements EventHandler {
    private final EventProcessor eventProcessor;

    private static Map<String, SensorEventType> eventTypeMap = new HashMap<>();
    static {
        eventTypeMap.put("LightIsOn", SensorEventType.LIGHT_ON);
        eventTypeMap.put("LightIsOff", SensorEventType.LIGHT_OFF);
        eventTypeMap.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        eventTypeMap.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        eventTypeMap.put("DoorIsLocked", SensorEventType.ALARM_ACTIVATE);
        eventTypeMap.put("DoorIsUnlocked", SensorEventType.ALARM_DEACTIVATE);
    }
    CCAdapter(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = new SensorEvent(eventTypeMap.get(event.getEventType()), event.getObjectId());
        eventProcessor.processEvent(sensorEvent);
    }
}
