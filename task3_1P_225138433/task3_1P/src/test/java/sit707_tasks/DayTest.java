package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class DayTest {

    @Test
    public void testValidDay() {
        System.out.println("DayTest - testValidDay: Creating date with day=15, month=6, year=2000");
        DateUtil date = new DateUtil(15, 6, 2000);
        System.out.println("DayTest - testValidDay: Created date -> " + date.toString());
        assertEquals(15, date.getDay());
        System.out.println("DayTest - testValidDay: PASSED");
    }

    @Test(expected = RuntimeException.class)
    public void testDayBelowMin() {
        System.out.println("DayTest - testDayBelowMin: Creating date with day=0, expecting RuntimeException");
        new DateUtil(0, 6, 2000);
        System.out.println("DayTest - testDayBelowMin: PASSED (exception thrown as expected)");
    }

    @Test(expected = RuntimeException.class)
    public void testDayAboveMax() {
        System.out.println("DayTest - testDayAboveMax: Creating date with day=32, expecting RuntimeException");
        new DateUtil(32, 6, 2000);
        System.out.println("DayTest - testDayAboveMax: PASSED (exception thrown as expected)");
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeDay() {
        System.out.println("DayTest - testNegativeDay: Creating date with day=-1, expecting RuntimeException");
        new DateUtil(-1, 6, 2000);
        System.out.println("DayTest - testNegativeDay: PASSED (exception thrown as expected)");
    }
}