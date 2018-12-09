package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;


public class HomeEventObserver implements EventManager{
    private static Collection<EventProcessor> eventProcessors;
    private EventProvider eventProvider;
    private SmartHome smartHome;

    public HomeEventObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public HomeEventObserver(EventProvider eventProvider) {
        this.eventProvider = eventProvider;
    }

    public void runEventLoop() {
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
