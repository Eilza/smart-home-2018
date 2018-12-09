package ru.sbt.mipt.oop;
<<<<<<< HEAD

public class SignalingDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHomeSource smartHome;

    public SignalingDecorator(EventProcessor processor, SmartHomeSource smartHome) {
=======
import ru.sbt.mipt.oop.Activate;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
<<<<<<< HEAD
import ru.sbt.mipt.oop.Alert;
=======
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d

public class SignalingDecorator implements EventProcessor {
    private final EventProcessor processor;
    private final SmartHome smartHome;

    public SignalingDecorator(EventProcessor processor, SmartHome smartHome) {
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        this.processor = processor;
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (smartHome.getSignaling().getState() instanceof Activate) {
            smartHome.getSignaling().setToAlert();
<<<<<<< HEAD
            return;
        }
        if (smartHome.getSignaling().getState() instanceof Alert) {
            return;
        }
=======
        }
<<<<<<< HEAD
        if (smartHome.getSignaling().getState() instanceof Alert) {
            return;
        }
=======
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        processor.processEvent(event);
    }
}
