package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class HallDoorEventProcessorTest {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();


    @Test
    public void testHallDoorProcessEvent() throws IOException {


        SmartHome smartHome = smartHomeLoader.load().toSmartHome(); // загружаем умный дом

        String doorId = hallDoorId(smartHome).getId();

        System.out.println("Hall door id is: " + doorId );

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId);


        new HallDoorEventProcessor(smartHome).processEvent(event1);


        assertEquals( 0, numberOfOnLigths( smartHome ) );


    }

    public static Door hallDoorId(SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                return room.getDoors().iterator().next();
            }
        }
        return null;
    }


    public int numberOfOnLigths(SmartHome smartHome){
        int counLightsIsOn = 0;

        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                if(light.isOn()){
                    counLightsIsOn ++;
                }
            }
        }
      return counLightsIsOn;
    }
}