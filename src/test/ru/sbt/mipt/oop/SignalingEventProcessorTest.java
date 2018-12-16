package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SignalingEventProcessorTest {
    @Mock
    private SensorEvent alarmEvent;

    @Mock
    private  SensorEvent otherEvent;

    @Mock
    private SmartHome homeMock;
    @InjectMocks
    private  SignalingEventProcessor processor;

    @Test
    void executeActionOnSmartHomeWithDoorOpenEventTest() {
        Mockito.when(alarmEvent.getObjectId()).thenReturn("4444");
        Mockito.when(alarmEvent.getType()).thenReturn(SensorEventType.ALARM_ACTIVATE);
        processor.processEvent(alarmEvent);
        Mockito.verify(homeMock).activateSignaling("4444");

    }
    @Test
    void executeActionOnSmartHomeWithDoorClosedEventTest() {
        Mockito.when(alarmEvent.getObjectId()).thenReturn("4444");
        Mockito.when(alarmEvent.getType()).thenReturn(SensorEventType.ALARM_DEACTIVATE);
        processor.processEvent(alarmEvent);
        Mockito.verify(homeMock).deactivateSignaling("4444");
    }

    @Test
    void executeActionOnSmartHomeWithOtherEventTest() {
        Mockito.when(otherEvent.getType()).thenReturn(SensorEventType.LIGHT_ON);
        processor.processEvent(otherEvent);
        Mockito.verifyNoMoreInteractions(homeMock);

    }
}
