package ru.sbt.mipt.oop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Combinator {
    private static SmartHome smartHome;
    private EventManager manager;

    public Combinator() {
    }

    @Bean
    EventManager eventManager() {
        manager = new EventManagerAdapter();
        try {
            smartHome = new FileLoaderAdapter().load().toSmartHome();
        } catch (IOException e) {
            e.printStackTrace();
        }
        combineManager(smartHome);
        return manager;
    }

    public void combineManager(SmartHome smartHome) {
        Collection<EventProcessor> processors = combineEventProcessors(smartHome);
        for (EventProcessor p: processors) {
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