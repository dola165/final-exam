package ge.itvet.exam.utility;

import java.util.List;

public class ScoreCalculator {
    private static final double DEFAULT_SCORE = 5.0;

    // Method to calculate the average score and return default if no scores exist
    public static double calculateAverageScore(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return DEFAULT_SCORE; // Return default if there are no scores
        }

        double average = scores.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(DEFAULT_SCORE); // If no valid scores, return default
        return average;
    }
}
