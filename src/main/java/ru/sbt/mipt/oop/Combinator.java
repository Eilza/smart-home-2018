package ru.sbt.mipt.oop;
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
        return eventProcessors;
    }
}