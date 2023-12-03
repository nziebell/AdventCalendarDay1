import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // File path of the calibration document
        String filePath = "C:\\Users\\nickz\\IdeaProjects\\adventCalendarDay1\\src\\calibration.txt";

        // Initialize the sum
        int totalSum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Find the first and last digits in the line
                char firstDigit = findFirstDigit(line);
                char lastDigit = findLastDigit(line);

                // Combine the first and last digits to form a two-digit number
                int calibrationValue = Integer.parseInt("" + firstDigit + lastDigit);

                // Add the calibration value to the total sum
                totalSum += calibrationValue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the final result
        System.out.println("The sum of all calibration values is: " + totalSum);
    }

    private static char findFirstDigit(String line) {
        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
                return ch;
            }
        }
        throw new IllegalArgumentException("No digit found in the line: " + line);
    }

    private static char findLastDigit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            char ch = line.charAt(i);
            if (Character.isDigit(ch)) {
                return ch;
            }
        }
        throw new IllegalArgumentException("No digit found in the line: " + line);
    }
}
