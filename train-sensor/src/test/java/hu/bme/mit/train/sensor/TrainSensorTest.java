package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainSensor trainSensor;
    TrainUser user;

    @Before
    public void before() {
        controller = Mockito.mock(TrainController.class);
        user = new TrainUserImpl(controller);
        trainSensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void testSpeedLimitUnder0() {
        Mockito.when(controller.getReferenceSpeed()).thenReturn(10);
        trainSensor.overrideSpeedLimit(-1);
        Assert.assertTrue(user.getAlarmState());
    }

    @Test
    public void testSpeedLimitOver500() throws Exception {
        Mockito.when(controller.getReferenceSpeed()).thenReturn(400);
        trainSensor.overrideSpeedLimit(501);
        Assert.assertTrue(user.getAlarmState());
    }

    @Test
    public void testSpeedLimitTooSLow() throws Exception {
        Mockito.when(controller.getReferenceSpeed()).thenReturn(150);
        trainSensor.overrideSpeedLimit(50);
        Assert.assertTrue(user.getAlarmState());
    }

    @Test
    public void testSpeedLimitOK() throws Exception {
        Mockito.when(controller.getReferenceSpeed()).thenReturn(20);
        trainSensor.overrideSpeedLimit(30);
        Assert.assertFalse(user.getAlarmState());
    }
}
