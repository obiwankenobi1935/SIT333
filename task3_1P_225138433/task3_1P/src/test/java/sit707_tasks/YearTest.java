package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class YearTest {

    @Test
    public void testValidYear() {
        System.out.println("YearTest - testValidYear: Creating date with day=15, month=6, year=2000");
        DateUtil date = new DateUtil(15, 6, 2000);
        System.out.println("YearTest - testValidYear: Created date -> " + date.toString());
        assertEquals(2000, date.getYear());
        System.out.println("YearTest - testValidYear: PASSED");
    }

    @Test(expected = RuntimeException.class)
    public void testYearBelowMin() {
        System.out.println("YearTest - testYearBelowMin: Creating date with year=1699, expecting RuntimeException");
        new DateUtil(15, 6, 1699);
        System.out.println("YearTest - testYearBelowMin: PASSED (exception thrown as expected)");
    }

    @Test(expected = RuntimeException.class)
    public void testYearAboveMax() {
        System.out.println("YearTest - testYearAboveMax: Creating date with year=2025, expecting RuntimeException");
        new DateUtil(15, 6, 2025);
        System.out.println("YearTest - testYearAboveMax: PASSED (exception thrown as expected)");
    }

    @Test(expected = RuntimeException.class)
    public void testYearWayBelowMin() {
        System.out.println("YearTest - testYearWayBelowMin: Creating date with year=0, expecting RuntimeException");
        new DateUtil(15, 6, 0);
        System.out.println("YearTest - testYearWayBelowMin: PASSED (exception thrown as expected)");
    }
}