package tasks;

public class BoyerMoore {

	// Function to find the last occurrence of a pattern in a given text
    public static int findLastOccurrence(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        if (m == 0) return -1;

        int[] badChar = new int[256];

        // Initialize all occurrences as -1
        for (int i = 0; i < 256; i++) {
            badChar[i] = -1;
        }

        // Fill the actual value of the last occurrence of a character in the pattern
        for (int i = 0; i < m; i++) {
            badChar[pattern.charAt(i)] = i;
        }

        int shift = 0;
        int lastOccurrence = -1;

        while (shift <= (n - m)) {
            int j = m - 1;

            // Keep reducing j while characters of pattern and text are matching at this shift
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }

            // If the pattern is present at the current shift, update lastOccurrence
            if (j < 0) {
                lastOccurrence = shift;
                shift += (shift + m < n) ? m - badChar[text.charAt(shift + m)] : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }

        return lastOccurrence;
    }

    // Main method to test the function
    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";
        int index = findLastOccurrence(text, pattern);
        if (index != -1) {
            System.out.println("Last occurrence of pattern found at index " + index);
        } else {
            System.out.println("Pattern not found in the given text");
        }
    }

}
