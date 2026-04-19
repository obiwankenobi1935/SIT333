package sit707_week5;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static int nHours;
    private static double[] hourlyTemperatures;

    @BeforeClass
    public static void setup() {
        System.out.println("+++ Setup: initialising WeatherController +++");
        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();

        hourlyTemperatures = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void teardown() {
        System.out.println("+++ Teardown: closing WeatherController +++");
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "225138433";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Kavish";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        double minTemperature = 1000;
        for (double temp : hourlyTemperatures) {
            if (minTemperature > temp) {
                minTemperature = temp;
            }
        }

        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        double maxTemperature = -1;
        for (double temp : hourlyTemperatures) {
            if (maxTemperature < temp) {
                maxTemperature = temp;
            }
        }

        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        double sumTemp = 0;
        for (double temp : hourlyTemperatures) {
            sumTemp += temp;
        }
        double averageTemp = sumTemp / nHours;

        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
    }
}