package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;


public class HomeEventObserver {
    private static Collection<EventProcessor> eventProcessors;
    private EventProvider eventProvider;

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
        }
    }
    public void addEventProcessor(EventProcessor processor) {
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
        eventProcessors.add(processor);
    }
    public void addAllEventProcessors( Collection<EventProcessor> processors) {
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
        eventProcessors.addAll(processors);
    }
}
