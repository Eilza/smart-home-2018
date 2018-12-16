package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HallDoorEventProcessorTest {
    @Mock
    private SensorEvent doorEvent;

    @Mock
    private SensorEvent otherEvent;

    @Mock
    private SmartHome homeMock;
    @InjectMocks
    private HallDoorEventProcessor processor;

    @Test
    void executeHomeGoRoundFunctionalWithCloseDoorEventTest () {
        Mockito.when(doorEvent.getType()).thenReturn(SensorEventType.DOOR_CLOSED);
        processor.processEvent(doorEvent);
        Mockito.verify(homeMock).executeHomeGoRoundFunctional(Mockito.any());
    }
    @Test
    void executeHomeGoRoundFunctionalWithOpenDoorEventTest () {
        Mockito.when(doorEvent.getType()).thenReturn(SensorEventType.DOOR_OPEN);
        processor.processEvent(doorEvent);
        Mockito.verifyNoMoreInteractions(homeMock);
    }
    @Test
    void executeHomeGoRoundFunctionalWithOtherEventTest () {
        Mockito.when(doorEvent.getType()).thenReturn(SensorEventType.LIGHT_ON);
        processor.processEvent(doorEvent);
        Mockito.verifyNoMoreInteractions(homeMock);
    }

}
