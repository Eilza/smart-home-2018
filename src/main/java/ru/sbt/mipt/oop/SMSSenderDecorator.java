package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.Activate;
import ru.sbt.mipt.oop.Alert;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class SMSSenderDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHome smartHome;
    public SMSSenderDecorator(EventProcessor processor, SmartHome smartHome) {
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
        }
        processor.processEvent(event);
    }
}
