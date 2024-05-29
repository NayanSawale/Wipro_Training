package tasks;

public class KMPAlgorithm {


    // Method to perform KMP search
    public static int KMPSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern
        int textLength = text.length();
        int patternLength = pattern.length();

        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == patternLength) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // If no pattern found, return -1
    }

    // Method to compute the Longest Prefix Suffix (LPS) array
    private static int[] computeLPSArray(String pattern) {
        int length = 0;
        int i = 1;
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        lps[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(text, pattern);
    }
}
