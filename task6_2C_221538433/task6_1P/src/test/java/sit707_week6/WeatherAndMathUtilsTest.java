package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "225138433";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Kavish Choudhary";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // ===================== EXISTING TESTS =====================

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    @Test
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    // ===================== BMI - BOUNDARY TESTS (B) =====================
    // Testing exact cutoff values and just above/below them.
    // Bug 1 will cause testBMIExactlyNormalLowerBound to FAIL.

    @Test
    public void testBMIUnderweight() {
        // BMI = 50 / (1.80 * 1.80) = 15.43 → Underweight
        Assert.assertEquals("Underweight", WeatherAndMathUtils.calculateBMI(50, 1.80));
    }

    @Test
    public void testBMIExactlyNormalLowerBound() {
        // BMI = exactly 18.5 → should be Normal (Bug 1 will return Underweight)
        double weight = 18.5 * 1.0 * 1.0; // height = 1.0m, so weight = 18.5kg gives BMI = 18.5
        Assert.assertEquals("Normal", WeatherAndMathUtils.calculateBMI(weight, 1.0));
    }

    @Test
    public void testBMIJustAboveNormalLowerBound() {
        // BMI just above 18.5 → Normal
        double weight = 18.6 * 1.0 * 1.0;
        Assert.assertEquals("Normal", WeatherAndMathUtils.calculateBMI(weight, 1.0));
    }

    @Test
    public void testBMIExactlyOverweightBound() {
        // BMI = exactly 25.0 → Overweight
        double weight = 25.0 * 1.0 * 1.0;
        Assert.assertEquals("Overweight", WeatherAndMathUtils.calculateBMI(weight, 1.0));
    }

    @Test
    public void testBMIJustBelowOverweightBound() {
        // BMI just below 25.0 → Normal
        double weight = 24.9 * 1.0 * 1.0;
        Assert.assertEquals("Normal", WeatherAndMathUtils.calculateBMI(weight, 1.0));
    }

    @Test
    public void testBMIExactlyObeseBound() {
        // BMI = exactly 30.0 → Obese
        double weight = 30.0 * 1.0 * 1.0;
        Assert.assertEquals("Obese", WeatherAndMathUtils.calculateBMI(weight, 1.0));
    }

    @Test
    public void testBMIJustBelowObeseBound() {
        // BMI just below 30.0 → Overweight
        double weight = 29.9 * 1.0 * 1.0;
        Assert.assertEquals("Overweight", WeatherAndMathUtils.calculateBMI(weight, 1.0));
    }

    // ===================== BMI - ERROR CONDITION TESTS (E) =====================
    // Bug 2: no validation in naive version — these will FAIL (no exception thrown).

    @Test(expected = IllegalArgumentException.class)
    public void testBMINegativeWeight() {
        WeatherAndMathUtils.calculateBMI(-70, 1.75);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBMINegativeHeight() {
        WeatherAndMathUtils.calculateBMI(70, -1.75);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBMIZeroWeight() {
        WeatherAndMathUtils.calculateBMI(0, 1.75);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBMIZeroHeight() {
        WeatherAndMathUtils.calculateBMI(70, 0);
    }

    // ===================== BMI - INVERSE TESTS (I) =====================
    // If BMI formula is correct, computing weight from a known BMI and height
    // should return the expected category consistently.
    // Bug 3: wrong formula will cause all of these to FAIL.

    @Test
    public void testBMIInverseNormal() {
        // BMI = 22.0, height = 1.75m → weight = 22.0 * 1.75 * 1.75 = 67.375kg
        double height = 1.75;
        double expectedBMI = 22.0;
        double weight = expectedBMI * height * height;
        Assert.assertEquals("Normal", WeatherAndMathUtils.calculateBMI(weight, height));
    }

    @Test
    public void testBMIInverseObese() {
        // BMI = 35.0, height = 1.70m → weight = 35.0 * 1.70 * 1.70 = 101.15kg
        double height = 1.70;
        double expectedBMI = 35.0;
        double weight = expectedBMI * height * height;
        Assert.assertEquals("Obese", WeatherAndMathUtils.calculateBMI(weight, height));
    }

    @Test
    public void testBMIInverseOverweight() {
        // BMI = 27.0, height = 1.80m → weight = 27.0 * 1.80 * 1.80 = 87.48kg
        double height = 1.80;
        double expectedBMI = 27.0;
        double weight = expectedBMI * height * height;
        Assert.assertEquals("Overweight", WeatherAndMathUtils.calculateBMI(weight, height));
    }

    @Test
    public void testBMIInverseUnderweight() {
        // BMI = 17.0, height = 1.65m → weight = 17.0 * 1.65 * 1.65 = 46.2825kg
        double height = 1.65;
        double expectedBMI = 17.0;
        double weight = expectedBMI * height * height;
        Assert.assertEquals("Underweight", WeatherAndMathUtils.calculateBMI(weight, height));
    }
}