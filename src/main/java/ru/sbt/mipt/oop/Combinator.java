package ru.sbt.mipt.oop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.DoorEventProcessor;
import ru.sbt.mipt.oop.HallDoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.LightsEventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeLoader;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Combinator {
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
        combineManager(smartHome);
        return manager;
    }

    public void combineManager(SmartHome smartHome) {
        Collection<EventProcessor> processors = combineEventProcessors(smartHome);
        for (EventProcessor p: processors) {
            //manager.registerEventHandler(new CCSAdapter(p));
            manager.addEventProcessor(p);
        }
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