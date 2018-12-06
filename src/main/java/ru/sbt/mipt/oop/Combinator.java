package ru.sbt.mipt.oop;

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
        return eventProcessors;
    }
}