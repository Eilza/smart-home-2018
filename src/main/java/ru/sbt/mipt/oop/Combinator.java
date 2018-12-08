package ru.sbt.mipt.oop;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.DoorEventProcessor;
import ru.sbt.mipt.oop.HallDoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.LightsEventProcessor;
import ru.sbt.mipt.oop.SmartHome;

public class Combinator {
    public static void combine(HomeEventObserver homeEventObserver, SmartHome smartHome) {
        homeEventObserver.addAllEventProcessors(combineEventProcessors(smartHome));
    }
    private static Collection<EventProcessor> combineEventProcessors(SmartHome smartHome) {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new SMSSenderDecorator(new SignalingDecorator(new LightsEventProcessor(smartHome),
                smartHome), smartHome));
        eventProcessors.add(new SMSSenderDecorator(new SignalingDecorator(new DoorEventProcessor(smartHome), smartHome),
                smartHome));
        eventProcessors.add(new SMSSenderDecorator(new SignalingDecorator(new HallDoorEventProcessor(smartHome), smartHome),
                smartHome));
        eventProcessors.add(new SignalingEventProcessor(smartHome));
=======

import java.util.ArrayList;
import java.util.Collection;

public class Combinator {
    public static void combine(HomeEventObserver homeEventObserver) {
    }
    private static Collection<EventProcessor> combineEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightsEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
        return eventProcessors;
    }
}