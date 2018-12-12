package ru.sbt.mipt.oop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SignalingTest {
    private static Signaling signaling= new Signaling();
    @Test
    public void activateFromDisabledTest() {
        signaling.activate( "145236");
        Assert.assertTrue(signaling.getState() instanceof Activate);
    }
    @Test
    public void activateFromActivatedTest() {
        signaling.activate( "145236");
        Assert.assertTrue(signaling.getState() instanceof Activate);
        signaling.activate( "31");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        Assert.assertTrue(!signaling.checkPassword("31"));
    }
    @Test
    public void activateFromAlarmTest() {
        signaling.activate( "145236");
        Assert.assertTrue(signaling.getState() instanceof Activate);
        signaling.activate( "31");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        signaling.activate( "1");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        Assert.assertTrue(!signaling.checkPassword("1"));
    }
    @Test
    public void deactivateFromActivatedWithRightPassTest() {
        signaling.activate( "145236");
        signaling.deactivate( "145236");
        Assert.assertTrue(signaling.getState() instanceof Deactivate);
        Assert.assertTrue(signaling.checkPassword("4444"));
    }
    @Test
    public void deactivateFromActivatedWithWrongPasseTest() {
        signaling.activate( "145236");
        signaling.deactivate( "31");
        Assert.assertTrue(signaling.getState() instanceof Alert);
    }
    @Test
    public void deactivateFromDeactivatedTest() {
        signaling.deactivate( "31");
        Assert.assertTrue(signaling.getState() instanceof Deactivate);
        Assert.assertTrue(signaling.checkPassword("4444"));
    }
    @Test
    public void deactivateFromAlarmTest() {
        signaling.activate( "145236");
        signaling.deactivate( "31");
        Assert.assertTrue(signaling.getState() instanceof Alert);
        signaling.deactivate( "145236");
        Assert.assertTrue(signaling.getState() instanceof Deactivate);
        Assert.assertTrue(signaling.checkPassword("4444"));
    }
}
