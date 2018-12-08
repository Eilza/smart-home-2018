package ru.sbt.mipt.oop;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

=======

import java.util.ArrayList;
import java.util.Collection;
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40

public class HomeEventObserver {
    private static Collection<EventProcessor> eventProcessors;
    private EventProvider eventProvider;
<<<<<<< HEAD

    public HomeEventObserver(EventProvider eventProvider) {
        this.eventProvider = eventProvider;
    }

    public void runEventLoop(SmartHome smartHome) {
        SensorEvent event = eventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Event: " + event);
            publish(event, eventProcessors);
            event = eventProvider.getNextSensorEvent();
        }
    }
    private static void publish(SensorEvent event, Collection<EventProcessor> eventProcessors) {
        for (EventProcessor p : eventProcessors) {
            p.processEvent(event);
=======
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
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
        }
    }
    public void addEventProcessor(EventProcessor processor) {
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
        eventProcessors.add(processor);
    }
    public void addAllEventProcessors( Collection<EventProcessor> processors) {
<<<<<<< HEAD
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
=======
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
        eventProcessors.addAll(processors);
    }
}
