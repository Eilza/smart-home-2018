package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class SignalingTest {
    Signaling signaling;

    @Test
    public void activateFromDeactivateState() {
        signaling = new Signaling();

        signaling.activate("4444");
        Assert.assertTrue(signaling.getState() instanceof Activate);

        signaling.changeState(new Deactivate(signaling));
        signaling.activate("12");
        Assert.assertTrue(signaling.getState() instanceof Alert);

    }

    @Test
    public void activateFromActiveStateTest() {
        signaling = new Signaling();
        signaling.activate("4444");
        Assert.assertTrue(signaling.getState() instanceof Activate);
        signaling.activate("31");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        Assert.assertTrue(!signaling.checkPassword("31"));
    }

    @Test
    public void activateFromAlertStateTest() {
        signaling = new Signaling();
        signaling.changeState(new Alert(signaling));

        signaling.activate("4444");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        signaling.activate("31");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        signaling.activate("1");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        Assert.assertTrue(!signaling.checkPassword("1"));

    }

    @Test
    public void deactivateFromActiveStateTest() {
        signaling = new Signaling();
        signaling.activate("4444");
        signaling.deactivate("4444");

        Assert.assertTrue(signaling.getState() instanceof Deactivate);
        Assert.assertTrue(signaling.checkPassword("4444"));

        signaling.activate("4444");
        signaling.deactivate("12");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        Assert.assertTrue(!signaling.checkPassword("12"));

    }

    @Test
    public void deactivateFromDeactiveStateTest() {
        signaling = new Signaling();

        signaling.deactivate("4444");
        Assert.assertTrue(signaling.getState() instanceof Deactivate);

        signaling.deactivate("31");
        Assert.assertTrue(signaling.getState() instanceof Deactivate);
        Assert.assertTrue(!signaling.checkPassword("31"));
    }

    @Test
    public void deactivateFromAlertStateTest() {
        signaling = new Signaling();

        signaling.activate("4444");
        signaling.deactivate("31");
        Assert.assertTrue(signaling.getState() instanceof Alert);

        signaling.deactivate("03");
        Assert.assertTrue(signaling.getState() instanceof Alert);

        signaling.deactivate("4444");

        Assert.assertTrue(signaling.getState() instanceof Deactivate);
        Assert.assertTrue(!signaling.checkPassword("03"));
    }
}
