package ru.sbt.mipt.oop;
import com.coolcompany.SensorEventsManager;
<<<<<<< HEAD

=======
import org.springframework.stereotype.Component;
import ru.sbt.mipt.oop.EventProcessor;

@Component
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
public class EventManagerAdapter implements EventManager {
    private SensorEventsManager manager;

    public EventManagerAdapter() {
        this.manager = new SensorEventsManager();
    }

<<<<<<< HEAD
    public EventManagerAdapter(SensorEventsManager manager) {
        this.manager = manager;
    }

=======
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
    @Override
    public void runEventLoop() {
        manager.start();
    }

    @Override
    public void addEventProcessor(EventProcessor processor) {
        manager.registerEventHandler(new CCAdapter(processor));
    }
}
