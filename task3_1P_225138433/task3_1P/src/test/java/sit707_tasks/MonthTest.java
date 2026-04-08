package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonthTest {

    @Test
    public void testValidMonth() {
        System.out.println("MonthTest - testValidMonth: Creating date with day=15, month=6, year=2000");
        DateUtil date = new DateUtil(15, 6, 2000);
        System.out.println("MonthTest - testValidMonth: Created date -> " + date.toString());
        assertEquals(6, date.getMonth());
        System.out.println("MonthTest - testValidMonth: PASSED");
    }

    @Test(expected = RuntimeException.class)
    public void testMonthBelowMin() {
        System.out.println("MonthTest - testMonthBelowMin: Creating date with month=0, expecting RuntimeException");
        new DateUtil(15, 0, 2000);
        System.out.println("MonthTest - testMonthBelowMin: PASSED (exception thrown as expected)");
    }

    @Test(expected = RuntimeException.class)
    public void testMonthAboveMax() {
        System.out.println("MonthTest - testMonthAboveMax: Creating date with month=13, expecting RuntimeException");
        new DateUtil(15, 13, 2000);
        System.out.println("MonthTest - testMonthAboveMax: PASSED (exception thrown as expected)");
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeMonth() {
        System.out.println("MonthTest - testNegativeMonth: Creating date with month=-1, expecting RuntimeException");
        new DateUtil(15, -1, 2000);
        System.out.println("MonthTest - testNegativeMonth: PASSED (exception thrown as expected)");
    }
}