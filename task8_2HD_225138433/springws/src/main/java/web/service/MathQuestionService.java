package web.service;

public class MathQuestionService {

    public static double q1Addition(String number1, String number2) {
        if (number1 == null || number2 == null || number1.trim().isEmpty() || number2.trim().isEmpty()) {
            return Double.NaN;
        }
        double result = Double.valueOf(number1) + Double.valueOf(number2);
        return result;
    }

    public static double q2Subtraction(String number1, String number2) {
        if (number1 == null || number2 == null || number1.trim().isEmpty() || number2.trim().isEmpty()) {
            return Double.NaN;
        }
        double result = Double.valueOf(number1) - Double.valueOf(number2);
        return result;
    }

    public static double q3Multiplication(String number1, String number2) {
        if (number1 == null || number2 == null || number1.trim().isEmpty() || number2.trim().isEmpty()) {
            return Double.NaN;
        }
        double result = Double.valueOf(number1) * Double.valueOf(number2);
        return result;
    }
}