package ru.sbt.mipt.oop;
<<<<<<< HEAD
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HomeEventObserverTest {
    @Mock
    private EventProvider eventProvider;
    private SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON,"1");
    @Mock
    private EventProcessor processor;

    @InjectMocks
    private HomeEventObserver observer;
    @Test
    void observerLoopTest() {
        Mockito.when(eventProvider.getNextSensorEvent()).thenReturn(event).thenReturn(null);
        observer.addEventProcessor(processor);
        observer.runEventLoop();
        Mockito.verify(eventProvider, Mockito.times(2)).getNextSensorEvent();
        Mockito.verify(processor).onEvent(event);

=======
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import org.junit.jupiter.api.BeforeAll;
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
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
<<<<<<< HEAD
        public void processEvent(SensorEvent event) {
=======
<<<<<<< HEAD
        public void processEvent(SensorEvent event) {
=======
        public void processEvent(SmartHome smartHome, SensorEvent event) {
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
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
<<<<<<< HEAD
        homeEventObserver.runEventLoop();
=======
        homeEventObserver.runEventLoop(null);
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
        Assert.assertEquals(10, ((TestProcessor) testProcessor).getCounter());
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
    }
}