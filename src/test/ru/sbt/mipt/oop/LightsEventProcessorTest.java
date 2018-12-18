package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class LightsEventProcessorTest {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();


    @Test
    public void testLightsProcessEvent() throws IOException {
        SmartHome smartHome = smartHomeLoader.load().toSmartHome(); // загружаем умный дом

        String lightId1 = "3";

        SensorEvent event1 = new SensorEvent(SensorEventType.LIGHT_ON, lightId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.LIGHT_OFF, lightId1);
        
        if (getLighById(smartHome, lightId1).isOn()) {  // если лампа включена, то выключаем ее и проверяем выключилась ли

            new LightsEventProcessor(smartHome).processEvent(event2);
            assertTrue(!getLighById(smartHome,lightId1).isOn());

        } else {  //если лампа выключена, то включаем ее и проверяем включена ли она
            new LightsEventProcessor(smartHome).processEvent(event1);
            assertTrue(getLighById(smartHome,lightId1).isOn());
        }
    }

    
    public static Light getLighById(SmartHome smartHome, String Id) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(Id)) {
                    return light;
                }
            }
        }
        return null;
    }
}
