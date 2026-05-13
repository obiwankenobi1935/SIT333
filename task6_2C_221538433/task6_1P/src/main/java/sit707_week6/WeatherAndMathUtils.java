package sit707_week6;

public class WeatherAndMathUtils {
    public static final double DANGEROUS_WINDSPEED = 70.0;
    public static final double DANGEROUS_RAINFALL = 6.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_RAINFALL = 4.0;

    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException();
        }

        String advice = "ALL CLEAR";

        if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
                || (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
            advice = "CANCEL";
        } else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
            advice = "WARN";
        }

        return advice;
    }

    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (isEven(n)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates BMI category based on weight and height.
     * Fixed:
     * - Bug 1: uses <= 18.5 for correct boundary classification
     * - Bug 2: throws IllegalArgumentException for negative/zero inputs
     * - Bug 3: height used directly in metres (no erroneous *100)
     *
     * @param weight in kilograms
     * @param height in metres
     * @return BMI category string
     */
    public static String calculateBMI(double weight, double height) {
        // FIX 2: validate inputs
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Weight and height must be positive values.");
        }

        // FIX 3: use height directly in metres
        double bmi = weight / (height * height);

        // FIX 1: use <= 18.5 for correct boundary
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 18.5) {
            return "Normal";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}