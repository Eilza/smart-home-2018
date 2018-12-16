package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SMSSenderDecoratorTest {
    private SensorEvent alertEvent = new SensorEvent(SensorEventType.LIGHT_ON, "1");

    @Mock
    private Signaling signaling;
    @Mock
    private SmartHome homeMock;
    @Mock
    private EventProcessor processor;
    @InjectMocks
    SMSSenderDecorator smsSenderDecorator;

    @Test
    void onEventWithActivatedStateTest() {
        AlertState state = new Activate(signaling, "4444");
        Mockito.when(signaling.getState()).thenReturn(state);
        Mockito.when(homeMock.getSignaling()).thenReturn(signaling);
        smsSenderDecorator.processEvent(alertEvent);
        Mockito.verifyNoMoreInteractions(processor);
    }

    @Test
    void onEventWithAlarmStateTest() {
        AlertState state = new Alert(signaling);
        Mockito.when(signaling.getState()).thenReturn(state);
        Mockito.when(homeMock.getSignaling()).thenReturn(signaling);
        smsSenderDecorator.processEvent(alertEvent);
        Mockito.verifyNoMoreInteractions(processor);
    }
    @Test
    void onEventWithDisabledStateTest() {
        AlertState state = new Deactivate(signaling);
        Mockito.when(signaling.getState()).thenReturn(state);
        Mockito.when(homeMock.getSignaling()).thenReturn(signaling);
        smsSenderDecorator.processEvent(alertEvent);
        Mockito.verify(processor).processEvent(alertEvent);
    }
}
