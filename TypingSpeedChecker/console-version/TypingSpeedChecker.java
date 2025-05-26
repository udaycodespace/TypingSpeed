import java.util.Scanner;

public class TypingSpeedChecker {
    public static void main(String[] args) {
        String testText = "The quick brown fox jumps over the lazy dog";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the following sentence:");
        System.out.println(testText);
        System.out.println("Press Enter when ready...");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        String typedText = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime; // in milliseconds
        double timeInMinutes = timeTaken / 60000.0;

        int wordCount = typedText.trim().split("\s+").length;
        double wpm = wordCount / timeInMinutes;

        int correctChars = 0;
        int minLen = Math.min(testText.length(), typedText.length());
        for (int i = 0; i < minLen; i++) {
            if (testText.charAt(i) == typedText.charAt(i)) {
                correctChars++;
            }
        }

        double accuracy = (correctChars / (double) testText.length()) * 100;

        System.out.printf("Time Taken: %.2f minutes\n", timeInMinutes);
        System.out.printf("WPM: %.2f\n", wpm);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        scanner.close();
    }
}