package ru.sbt.mipt.oop;
import com.coolcompany.SensorEventsManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class EventManagerAdapterTest {
    @Mock
    private EventProcessor processor;
    @Mock
    private SensorEventsManager manager;
    @InjectMocks
    private EventManagerAdapter adapter;
    @Test
    void addHomeEventProcessorTest() {
        adapter.addEventProcessor(processor);
        Mockito.verify(manager).registerEventHandler(Mockito.any(CCAdapter.class));
    }
    @Test
    void runEventLoopTest() {
        adapter.runEventLoop();
        Mockito.verify(manager).start();
    }
}