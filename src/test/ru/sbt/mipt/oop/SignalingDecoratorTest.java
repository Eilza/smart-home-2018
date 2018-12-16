package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SignalingDecoratorTest {
    private SensorEvent alertEvent;

    @Mock
    private Signaling signaling;// = new Signaling();
    @Mock
    private SmartHome homeMock;
    @Mock
    private EventProcessor processor;
    @InjectMocks
    SignalingDecorator decorator;

    @Test
    void onEventWithActivatedStateTest() {
        AlertState state = new Activate(signaling, "4444");
        Mockito.when(signaling.getState()).thenReturn(state);
        Mockito.when(homeMock.getSignaling()).thenReturn(signaling);
        decorator.processEvent(alertEvent);
        Mockito.verify(signaling).setToAlert();
        Mockito.verifyNoMoreInteractions(processor);
    }

    @Test
    void onEventWithAlarmStateTest() {
        AlertState state = new Alert(signaling);
        Mockito.when(signaling.getState()).thenReturn(state);
        Mockito.when(homeMock.getSignaling()).thenReturn(signaling);
        decorator.processEvent(alertEvent);
        Mockito.verifyNoMoreInteractions(processor);
    }
    @Test
    void onEventWithDisabledStateTest() {
        AlertState state = new Deactivate(signaling);
        Mockito.when(signaling.getState()).thenReturn(state);
        Mockito.when(homeMock.getSignaling()).thenReturn(signaling);
        decorator.processEvent(alertEvent);
        Mockito.verify(processor).processEvent(alertEvent);
    }
}
