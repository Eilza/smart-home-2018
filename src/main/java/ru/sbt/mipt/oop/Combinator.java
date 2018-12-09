package ru.sbt.mipt.oop;
<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import
=======
<<<<<<< HEAD
import java.io.IOException;
=======
<<<<<<< HEAD
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.DoorEventProcessor;
import ru.sbt.mipt.oop.HallDoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.LightsEventProcessor;
import ru.sbt.mipt.oop.SmartHome;
<<<<<<< HEAD
import ru.sbt.mipt.oop.SmartHomeLoader;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.EventManager;
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Combinator {
<<<<<<< HEAD
    private static SmartHomeSource smartHome;
    private EventManager manager;

    public Combinator() {
    }

    @Bean
    EventManager eventManager() {
        manager = new EventManagerAdapter();
        try {
            smartHome = new FileLoaderAdapter().load().toSmartHomeSource();
        } catch (IOException e) {
            e.printStackTrace();
        }
=======
    private static SmartHome smartHome;
    private static EventManager manager;

    public Combinator() {
        try {
            smartHome = new FileSmartHomeLoader().load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Combinator(SmartHomeLoader smartHomeLoader, EventManager manager){
        try {
            smartHome = smartHomeLoader.load();
            manager = manager;
            combineManager(smartHome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    EventManager eventManager() {
        manager = new EventManagerAdapter();
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        combineManager(smartHome);
        return manager;
    }

<<<<<<< HEAD
    public void combineManager(SmartHomeSource smartHome) {
        Collection<EventProcessor> processors = combineEventProcessors(smartHome);
        for (EventProcessor p: processors) {
=======
    public void combineManager(SmartHome smartHome) {
        Collection<EventProcessor> processors = combineEventProcessors(smartHome);
        for (EventProcessor p: processors) {
            //manager.registerEventHandler(new CCSAdapter(p));
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
            manager.addEventProcessor(p);
        }
    }

<<<<<<< HEAD
    private static Collection<EventProcessor> combineEventProcessors(SmartHomeSource smartHome) {
=======
=======

public class Combinator {
    public static void combine(HomeEventObserver homeEventObserver, SmartHome smartHome) {
        homeEventObserver.addAllEventProcessors(combineEventProcessors(smartHome));
    }
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
    private static Collection<EventProcessor> combineEventProcessors(SmartHome smartHome) {
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new SMSSenderDecorator(new SignalingDecorator(new LightsEventProcessor(smartHome),
                smartHome), smartHome));
        eventProcessors.add(new SMSSenderDecorator(new SignalingDecorator(new DoorEventProcessor(smartHome), smartHome),
                smartHome));
        eventProcessors.add(new SMSSenderDecorator(new SignalingDecorator(new HallDoorEventProcessor(smartHome), smartHome),
                smartHome));
        eventProcessors.add(new SignalingEventProcessor(smartHome));
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
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
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        return eventProcessors;
    }
}