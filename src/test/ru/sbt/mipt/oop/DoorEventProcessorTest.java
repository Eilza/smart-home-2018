package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class DoorEventProcessorTest {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();


    @Test
    public void testDoorProcessEvent() throws IOException {



        SmartHome smartHome = smartHomeLoader.load().toSmartHome(); // загружаем умный дом


        String doorId1 = "2";

        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId1);

        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId1);



        if (getDoorById(smartHome, doorId1).isOpen()) {  // если дверь открыта, то закроем ее и проверим закралась ли

            new DoorEventProcessor(smartHome).processEvent(event2);

            assertTrue(!getDoorById(smartHome, doorId1).isOpen());

        } else {                    // если дверь закрыта, то откроем ее и посмотрим открылась ли
            new DoorEventProcessor(smartHome).processEvent(event1);

            assertTrue(getDoorById(smartHome, doorId1).isOpen());
        }

    }



    public static Door getDoorById(SmartHome smartHome, String Id) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(Id)) {
                    return door;
                }
            }
        }
        return null;

    }
}
