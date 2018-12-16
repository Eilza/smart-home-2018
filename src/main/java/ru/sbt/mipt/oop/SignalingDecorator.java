package ru.sbt.mipt.oop;

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
            return;
        }
        if (smartHome.getSignaling().getState() instanceof Alert) {
            return;
        }
        processor.processEvent(event);
    }
}
