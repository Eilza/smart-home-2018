package ru.sbt.mipt.oop;
<<<<<<< HEAD

public class SMSSenderDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHomeSource smartHome;

    public SMSSenderDecorator(EventProcessor processor, SmartHomeSource smartHome) {
=======
import ru.sbt.mipt.oop.Activate;
import ru.sbt.mipt.oop.Alert;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class SMSSenderDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHome smartHome;
    public SMSSenderDecorator(EventProcessor processor, SmartHome smartHome) {
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        this.processor = processor;
        this.smartHome = smartHome;
    }
    @Override
    public void processEvent(SensorEvent event) {
        if(smartHome.getSignaling().getState() instanceof Activate) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
            System.out.println("Sending sms: \"Alert!Signaling was activated!"+ event.toString() +"\"");
            return;
        }
        if (smartHome.getSignaling().getState() instanceof Alert) {
            System.out.println("Sending sms: \"Alert!Someone try to get into the house!"+ event.toString()+"\"");
<<<<<<< HEAD
            return;
        }
=======
=======
            System.out.println("Sending sms: \"Alert!Signaling was activated!\" ");
            return;
        }
        if (smartHome.getSignaling().getState() instanceof Alert) {
            System.out.println("Sending sms: \"Alert!Someone try to get into the house!\"");
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
        }
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        processor.processEvent(event);
    }
}
