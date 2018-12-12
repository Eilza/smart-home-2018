package ru.sbt.mipt.oop;
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
        Mockito.verify(processor).processEvent(event);

    }
}