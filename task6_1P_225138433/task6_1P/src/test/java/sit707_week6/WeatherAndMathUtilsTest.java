package sit707_week6;

import org.junit.Assert;
import static sit707_week6.WeatherAndMathUtils.*; 
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
	
	@Test
	public void testNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}
	
	@Test
	public void testFalseNumberisEven() {
		Assert.assertFalse(isEven(3));
	}
	
	@Test
	public void test0isEven() {
		Assert.assertTrue(isEven(0));
	}
	
	@Test
	public void testIfNegativeOddIntegerIsEven() {
		Assert.assertFalse(isEven(-3));
	}
	
	@Test
	public void testIfNegativeEvenIntegerIsEven() {
		Assert.assertFalse(isEven(-11));
	}
	
	@Test
	public void testIfZeroIsPrime() {
		Assert.assertTrue(isPrime(0));
	}
	
	@Test
	public void testIfOneIsPrime() {
		Assert.assertTrue(isPrime(1));
	}
	
	@Test
	public void testIfTwoIsPrime() {
		Assert.assertTrue(isPrime(2));
	}
	
	@Test
	public void TestIfNineIsPrime() {
		Assert.assertTrue(isPrime(9));
	}
	
	@Test
	public void TestIfFourIsPrime() {
		Assert.assertFalse(isPrime(4));
	}
	
	@Test
	public void testAllClear() {
	    Assert.assertEquals("ALL CLEAR", weatherAdvice(0.0, 0.0));
	}

	@Test
	public void testCancelDangerousWind() {
	    Assert.assertEquals("CANCEL", weatherAdvice(70.1, 0.0));
	}

	@Test
	public void testCancelDangerousRainfall() {
	    Assert.assertEquals("CANCEL", weatherAdvice(0.0, 6.1));
	}

	@Test
	public void testCancelBothConcerning() {
	    Assert.assertEquals("CANCEL", weatherAdvice(45.1, 4.1));
	}

	@Test
	public void testWarnConcerningWind() {
	    Assert.assertEquals("WARN", weatherAdvice(45.1, 0.0));
	}

	@Test
	public void testWarnConcerningRainfall() {
	    Assert.assertEquals("WARN", weatherAdvice(0.0, 4.1));
	}
	
    @Test
    public void testCancelWeatherAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
}
