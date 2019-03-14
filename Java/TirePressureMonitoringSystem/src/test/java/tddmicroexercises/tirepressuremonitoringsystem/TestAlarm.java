package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarm {

    @Test
    public void whenInstantiatingIsNotNull() {
        Alarm alarm = new Alarm();
        Assert.assertNotNull(alarm);
    }

    @Test
    public void whenCallingCheck_WithLowPressure_AlarmSounds() {
        Sensor sensorMock = mock(Sensor.class);
        Alarm alarm = new Alarm(sensorMock);

        when(sensorMock.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void whenCallingCheck_WithHightPressure_AlarmSounds() {
        Sensor sensorMock = mock(Sensor.class);
        Alarm alarm = new Alarm(sensorMock);

        when(sensorMock.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void whenCallingCheck_WithNormalPressure_AlarmIsOff() {
        Sensor sensorMock = mock(Sensor.class);
        Alarm alarm = new Alarm(sensorMock);

        when(sensorMock.popNextPressurePsiValue()).thenReturn(20.0);
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

}
