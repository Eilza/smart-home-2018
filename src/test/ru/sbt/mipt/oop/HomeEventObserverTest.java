package ru.sbt.mipt.oop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.EventProvider;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class HomeEventObserverTest {
    HomeEventObserver homeEventObserver;
    @Before
    public void init() {
        homeEventObserver = new HomeEventObserver(new EventProvider() {
            private int counter;
            @Override
            public SensorEvent getNextSensorEvent() {
                counter++;
                if (counter <= 10) {
                    return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
                } else {
                    return null;
                }
            }
        });
    }
    private class TestProcessor implements EventProcessor {
        private int counter;
        @Override
        public void processEvent(SensorEvent event) {
            if (event.getType() == SensorEventType.DOOR_OPEN) {
                counter++;
            }
        }
        public int getCounter() {
            return counter;
        }
    }
    @Test
    public void observerTest() {
        EventProcessor testProcessor = new TestProcessor();
        homeEventObserver.addEventProcessor(testProcessor);
        homeEventObserver.runEventLoop();
        Assert.assertEquals(10, ((TestProcessor) testProcessor).getCounter());
    }
}