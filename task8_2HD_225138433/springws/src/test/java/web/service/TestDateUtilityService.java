package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestDateUtilityService {

    // ── dateAfterDays ────────────────────────────────────────

    @Test
    public void testDateAfterDays_CorrectResult() {
        Assert.assertEquals("2024-02-15", DateUtilityService.dateAfterDays("2024-01-01", "45"));
    }

    @Test
    public void testDateAfterDays_ZeroDays_SameDate() {
        Assert.assertEquals("2024-03-10", DateUtilityService.dateAfterDays("2024-03-10", "0"));
    }

    @Test
    public void testDateAfterDays_CrossMonthBoundary() {
        Assert.assertEquals("2024-03-01", DateUtilityService.dateAfterDays("2024-02-29", "1"));
    }

    @Test
    public void testDateAfterDays_CrossYearBoundary() {
        Assert.assertEquals("2025-01-01", DateUtilityService.dateAfterDays("2024-12-31", "1"));
    }

    @Test
    public void testDateAfterDays_LargeDays() {
        Assert.assertEquals("2026-12-27", DateUtilityService.dateAfterDays("2024-01-01", "1091"));
    }

    @Test
    public void testDateAfterDays_NullStartDate_ReturnsNull() {
        Assert.assertNull(DateUtilityService.dateAfterDays(null, "10"));
    }

    @Test
    public void testDateAfterDays_NullDays_ReturnsNull() {
        Assert.assertNull(DateUtilityService.dateAfterDays("2024-01-01", null));
    }

    @Test
    public void testDateAfterDays_EmptyStartDate_ReturnsNull() {
        Assert.assertNull(DateUtilityService.dateAfterDays("", "10"));
    }

    @Test
    public void testDateAfterDays_EmptyDays_ReturnsNull() {
        Assert.assertNull(DateUtilityService.dateAfterDays("2024-01-01", ""));
    }

    // ── daysBetween ──────────────────────────────────────────

    @Test
    public void testDaysBetween_CorrectResult() {
        Assert.assertEquals(31, DateUtilityService.daysBetween("2024-01-01", "2024-02-01"));
    }

    @Test
    public void testDaysBetween_SameDate_ReturnsZero() {
        Assert.assertEquals(0, DateUtilityService.daysBetween("2024-05-01", "2024-05-01"));
    }

    @Test
    public void testDaysBetween_NegativeResult_Date2BeforeDate1() {
        Assert.assertEquals(-10, DateUtilityService.daysBetween("2024-06-10", "2024-05-31"));
    }

    @Test
    public void testDaysBetween_AcrossYears() {
        Assert.assertEquals(366, DateUtilityService.daysBetween("2024-01-01", "2025-01-01"));
    }

    @Test
    public void testDaysBetween_NullDate1_ReturnsMinValue() {
        Assert.assertEquals(Long.MIN_VALUE, DateUtilityService.daysBetween(null, "2024-01-01"));
    }

    @Test
    public void testDaysBetween_NullDate2_ReturnsMinValue() {
        Assert.assertEquals(Long.MIN_VALUE, DateUtilityService.daysBetween("2024-01-01", null));
    }

    @Test
    public void testDaysBetween_EmptyDate1_ReturnsMinValue() {
        Assert.assertEquals(Long.MIN_VALUE, DateUtilityService.daysBetween("", "2024-01-01"));
    }

    @Test
    public void testDaysBetween_EmptyDate2_ReturnsMinValue() {
        Assert.assertEquals(Long.MIN_VALUE, DateUtilityService.daysBetween("2024-01-01", ""));
    }
}