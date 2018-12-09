package ru.sbt.mipt.oop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.*;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;

public class DoorEventProcessorTest {
    public static SensorEvent doorClosedEvent;
    public static SensorEvent otherEvent;
    public static SensorEvent doorOpenEvent;
    @Mock
    public static SmartHome homeMock;// = Mockito.mock(SmartHome.class);
    @BeforeAll
    public static void init() {
        doorOpenEvent = Mockito.mock(SensorEvent.class);
        Mockito.when(doorOpenEvent.getType()).thenReturn(SensorEventType.DOOR_OPEN);
        doorClosedEvent = Mockito.mock(SensorEvent.class);
        Mockito.when(doorClosedEvent.getType()).thenReturn(SensorEventType.DOOR_CLOSED);
        otherEvent = Mockito.mock(SensorEvent.class);
        Mockito.when(otherEvent.getType()).thenReturn(SensorEventType.LIGHT_ON);
    }
    @Test
    public void executeActionOnSmartHomeWithDoorOpenEventTest() {
        EventProcessor processor = new DoorEventProcessor(homeMock);
        processor.processEvent(doorOpenEvent);
        Mockito.verify(homeMock).executeAction(Mockito.any());
        Mockito.verifyNoMoreInteractions(homeMock);
    }
    @Test
    public void executeActionOnSmartHomeWithDoorClosedEventTest() {
        EventProcessor processor = new DoorEventProcessor(homeMock);
        processor.processEvent(doorClosedEvent);
        Mockito.verify(homeMock).executeAction(Mockito.any());
        Mockito.verifyNoMoreInteractions(homeMock);
    }
    @Test
    public void executeActionOnSmartHomeWithOtherEventTest() {
        EventProcessor processor = new DoorEventProcessor(homeMock);
        processor.processEvent(otherEvent);
        Mockito.verifyNoMoreInteractions(homeMock);
    }
}
}
