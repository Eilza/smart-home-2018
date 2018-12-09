package ru.sbt.mipt.oop;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

<<<<<<< HEAD

public class HomeEventObserver implements EventManager{
    private static Collection<EventProcessor> eventProcessors;
    private EventProvider eventProvider;
    private SmartHome smartHome;

    public HomeEventObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
=======
=======

import java.util.ArrayList;
import java.util.Collection;
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40

public class HomeEventObserver {
    private static Collection<EventProcessor> eventProcessors;
    private EventProvider eventProvider;
<<<<<<< HEAD
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d

    public HomeEventObserver(EventProvider eventProvider) {
        this.eventProvider = eventProvider;
    }

<<<<<<< HEAD
    public void runEventLoop() {
=======
    public void runEventLoop(SmartHome smartHome) {
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
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
<<<<<<< HEAD
=======
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
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
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
<<<<<<< HEAD
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
=======
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
        eventProcessors.addAll(processors);
    }
}
