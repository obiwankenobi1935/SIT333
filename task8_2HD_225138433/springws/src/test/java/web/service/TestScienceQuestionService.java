package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestScienceQuestionService {

    // ── calculateForce ───────────────────────────────────────

    @Test
    public void testCalculateForce_CorrectResult() {
        Assert.assertEquals(20.0, ScienceQuestionService.calculateForce("4", "5"), 0);
    }

    @Test
    public void testCalculateForce_ZeroMass_ReturnsZero() {
        Assert.assertEquals(0.0, ScienceQuestionService.calculateForce("0", "9.8"), 0);
    }

    @Test
    public void testCalculateForce_ZeroAcceleration_ReturnsZero() {
        Assert.assertEquals(0.0, ScienceQuestionService.calculateForce("10", "0"), 0);
    }

    @Test
    public void testCalculateForce_DecimalValues() {
        Assert.assertEquals(49.0, ScienceQuestionService.calculateForce("5", "9.8"), 0.0001);
    }

    @Test
    public void testCalculateForce_NegativeAcceleration() {
        Assert.assertEquals(-30.0, ScienceQuestionService.calculateForce("5", "-6"), 0);
    }

    @Test
    public void testCalculateForce_LargeValues() {
        Assert.assertEquals(1000000.0, ScienceQuestionService.calculateForce("1000", "1000"), 0);
    }

    @Test
    public void testCalculateForce_NullMass_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(ScienceQuestionService.calculateForce(null, "5")));
    }

    @Test
    public void testCalculateForce_NullAcceleration_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(ScienceQuestionService.calculateForce("10", null)));
    }

    @Test
    public void testCalculateForce_EmptyMass_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(ScienceQuestionService.calculateForce("", "5")));
    }

    @Test
    public void testCalculateForce_EmptyAcceleration_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(ScienceQuestionService.calculateForce("10", "")));
    }
}