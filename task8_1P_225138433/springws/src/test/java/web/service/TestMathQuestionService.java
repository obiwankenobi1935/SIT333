package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // ── Q1 Addition ──────────────────────────────────────────

    @Test
    public void testQ1Addition_CorrectResult() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testQ1Addition_NegativeNumbers() {
        Assert.assertEquals(-1.0, MathQuestionService.q1Addition("-3", "2"), 0);
    }

    @Test
    public void testQ1Addition_ZeroValues() {
        Assert.assertEquals(0.0, MathQuestionService.q1Addition("0", "0"), 0);
    }

    @Test
    public void testQ1Addition_DecimalNumbers() {
        Assert.assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3.0"), 0);
    }

    @Test
    public void testQ1Addition_Number1Empty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "2")));
    }

    @Test
    public void testQ1Addition_Number2Empty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("5", "")));
    }

    @Test
    public void testQ1Addition_BothEmpty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "")));
    }

    @Test
    public void testQ1Addition_NullInput_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition(null, "2")));
    }

    // ── Q2 Subtraction ───────────────────────────────────────

    @Test
    public void testQ2Subtraction_CorrectResult() {
        Assert.assertEquals(3.0, MathQuestionService.q2Subtraction("5", "2"), 0);
    }

    @Test
    public void testQ2Subtraction_NegativeResult() {
        Assert.assertEquals(-2.0, MathQuestionService.q2Subtraction("3", "5"), 0);
    }

    @Test
    public void testQ2Subtraction_ZeroValues() {
        Assert.assertEquals(0.0, MathQuestionService.q2Subtraction("0", "0"), 0);
    }

    @Test
    public void testQ2Subtraction_DecimalNumbers() {
        Assert.assertEquals(1.5, MathQuestionService.q2Subtraction("4.5", "3.0"), 0);
    }

    @Test
    public void testQ2Subtraction_Number1Empty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("", "2")));
    }

    @Test
    public void testQ2Subtraction_Number2Empty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("5", "")));
    }

    @Test
    public void testQ2Subtraction_NullInput_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction(null, null)));
    }

    // ── Q3 Multiplication ────────────────────────────────────

    @Test
    public void testQ3Multiplication_CorrectResult() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0);
    }

    @Test
    public void testQ3Multiplication_ByZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("5", "0"), 0);
    }

    @Test
    public void testQ3Multiplication_NegativeNumbers() {
        Assert.assertEquals(-6.0, MathQuestionService.q3Multiplication("-2", "3"), 0);
    }

    @Test
    public void testQ3Multiplication_TwoNegatives() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("-2", "-3"), 0);
    }

    @Test
    public void testQ3Multiplication_DecimalNumbers() {
        Assert.assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3.0"), 0);
    }

    @Test
    public void testQ3Multiplication_Number1Empty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("", "3")));
    }

    @Test
    public void testQ3Multiplication_BothEmpty_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("", "")));
    }

    @Test
    public void testQ3Multiplication_NullInput_ReturnsNaN() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication(null, "3")));
    }
}