package sit707_tasks;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "225138433";
		System.out.println("Student ID: " + studentId);
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Kavish Choudhary";
		System.out.println("Student Name: " + studentName);
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// Code here
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("New Year Day: " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("New Year Day: " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	private void assertIncrement(int day, int month, int year, int expectedDate, int expectedMonth, int expectedYear) {
		DateUtil date = new DateUtil(day, month, year);
		System.out.println("Date Before: " + date);
		date.increment();
		System.out.println("Date after increment operation: " + date);
		Assert.assertEquals(expectedDate, date.getDay());
		Assert.assertEquals(expectedMonth, date.getMonth());
		Assert.assertEquals(expectedYear, date.getYear());
	}
	
	@Test
	public void testJune15ShouldIncrementToJune16() {
		assertIncrement(15, 6, 1994, 16, 6, 1994);
	}
	
	@Test
	public void testJune30ShouldIncrementToJuly1() {
		assertIncrement(30, 6, 1994, 1, 7, 1994);
	}
	
	@Test
	public void testInvalidDate() {
		try {
			new DateUtil(31, 6, 1994);
			Assert.fail("Expected Exception Not Found");
		}
		catch (RuntimeException e)
		{
			Assert.assertTrue(e.getMessage().contains("Invalid Day"));
		}
	}
	
	@Test
	public void testJanuary15ShouldIncrementToJanuary16() {
		assertIncrement(15, 1, 1994, 16, 1, 1994);
	}
	
	@Test
	public void testFebruary15ShouldIncrementToFebruary16() {
		assertIncrement(15, 2, 1994, 16, 2, 1994);
	}
	
	@Test
	public void testNovember15ShouldIncrementToNovember16() {
		assertIncrement(15, 11, 1994, 16, 11, 1994);
	}
	
	@Test
	public void testDecember15ShouldIncrementToDecember16() {
		assertIncrement(15, 12, 1994, 16, 12, 1994);
	}
	
	@Test
	public void test1700June15ShouldIncrementToJune16() {
		assertIncrement(15, 6, 1700, 16, 6, 1700);
	}
	
	@Test
	public void test1701June15ShouldIncrementToJune16() {
		assertIncrement(15, 6, 1701, 16, 6, 1701);
	}
	
	@Test
	public void test2023June15ShouldIncrementToJune16() {
		assertIncrement(15, 6, 2023, 16, 6, 2023);
	}
}
