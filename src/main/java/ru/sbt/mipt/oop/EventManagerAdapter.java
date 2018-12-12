package ru.sbt.mipt.oop;
import com.coolcompany.SensorEventsManager;

public class EventManagerAdapter implements EventManager {
    private SensorEventsManager manager;

    public EventManagerAdapter() {
        this.manager = new SensorEventsManager();
    }

    @Override
    public void runEventLoop() {
        manager.start();
    }

    @Override
    public void addEventProcessor(EventProcessor processor) {
        manager.registerEventHandler(new CCAdapter(processor));
    }
}
