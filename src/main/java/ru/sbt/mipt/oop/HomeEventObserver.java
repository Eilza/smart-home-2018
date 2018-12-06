package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventObserver {
    private static Collection<EventProcessor> eventProcessors;
    private EventProvider eventProvider;
    public HomeEventObserver(EventProvider eventProvider) {
        this.eventProvider = eventProvider;
    }
    public void runEventLoop(SmartHome smartHome) {
        SensorEvent event = eventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            publish(smartHome, event, eventProcessors);
            event = eventProvider.getNextSensorEvent();
        }
    }
    private static void publish(SmartHome smartHome, SensorEvent event, Collection<EventProcessor> eventProcessors) {
        for (EventProcessor p : eventProcessors) {
            p.processEvent(smartHome, event);
        }
    }
    public void addEventProcessor(EventProcessor processor) {
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
        eventProcessors.add(processor);
    }
    public void addAllEventProcessors( Collection<EventProcessor> processors) {
        eventProcessors.addAll(processors);
    }
}
