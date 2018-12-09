package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.Activate;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.Alert;

public class SignalingDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHome smartHome;

    public SignalingDecorator(EventProcessor processor, SmartHome smartHome) {
        this.processor = processor;
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (smartHome.getSignaling().getState() instanceof Activate) {
            smartHome.getSignaling().setToAlert();
        }
        if (smartHome.getSignaling().getState() instanceof Alert) {
            return;
        }
        processor.processEvent(event);
    }
}
