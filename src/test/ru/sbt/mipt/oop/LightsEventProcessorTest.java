package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LightsEventProcessorTest {
    @Mock
    private SensorEvent lightEvent;

    @Mock
    private  SensorEvent otherEvent;

    @Mock
    private SmartHome homeMock;
    @InjectMocks
    private  LightsEventProcessor processor;



    @Test
    void executeHomeGoRoundFunctionalOnSmartHomeWithLightOnEventTest() {
        Mockito.when(lightEvent.getType()).thenReturn(SensorEventType.LIGHT_ON);
        processor.processEvent(lightEvent);
        Mockito.verify(homeMock).executeHomeGoRoundFunctional(Mockito.any());
    }

    @Test
    void executeHomeGoRoundFunctionalOnSmartHomeWithLightsOffEventTest() {
        Mockito.when(lightEvent.getType()).thenReturn(SensorEventType.LIGHT_OFF);
        processor.processEvent(lightEvent);
        Mockito.verify(homeMock).executeHomeGoRoundFunctional(Mockito.any());
    }

    @Test
    void executeHomeGoRoundFunctionalOnSmartHomeWithOtherEventTest() {
        Mockito.when(otherEvent.getType()).thenReturn(SensorEventType.ALARM_ACTIVATE);
        processor.processEvent(otherEvent);
        Mockito.verifyNoMoreInteractions(homeMock);
    }
}
