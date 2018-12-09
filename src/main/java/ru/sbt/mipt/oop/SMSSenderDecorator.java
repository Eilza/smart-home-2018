package ru.sbt.mipt.oop;

public class SMSSenderDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHomeSource smartHome;

    public SMSSenderDecorator(EventProcessor processor, SmartHomeSource smartHome) {
        this.processor = processor;
        this.smartHome = smartHome;
    }
    @Override
    public void processEvent(SensorEvent event) {
        if(smartHome.getSignaling().getState() instanceof Activate) {
            System.out.println("Sending sms: \"Alert!Signaling was activated!"+ event.toString() +"\"");
            return;
        }
        if (smartHome.getSignaling().getState() instanceof Alert) {
            System.out.println("Sending sms: \"Alert!Someone try to get into the house!"+ event.toString()+"\"");
            return;
        }
        processor.processEvent(event);
    }
}
