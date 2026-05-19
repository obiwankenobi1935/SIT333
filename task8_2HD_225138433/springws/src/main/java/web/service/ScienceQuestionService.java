package web.service;

public class ScienceQuestionService {

    // Newton's Second Law: F = m * a
    public static double calculateForce(String massStr, String accelerationStr) {
        if (massStr == null || accelerationStr == null || massStr.trim().isEmpty() || accelerationStr.trim().isEmpty()) {
            return Double.NaN;
        }
        double mass = Double.parseDouble(massStr.trim());
        double acceleration = Double.parseDouble(accelerationStr.trim());
        return mass * acceleration;
    }
}