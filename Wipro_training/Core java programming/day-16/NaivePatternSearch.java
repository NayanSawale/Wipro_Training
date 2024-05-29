package tasks;

public class NaivePatternSearch {

	 public static void naivePatternSearch(String text, String pattern) {
	        int textLength = text.length();
	        int patternLength = pattern.length();
	        int comparisonCount = 0;

	        // Loop through the text to check for pattern matches
	        for (int i = 0; i <= textLength - patternLength; i++) {
	            int j;
	            
	            // Check for pattern match
	            for (j = 0; j < patternLength; j++) {
	                comparisonCount++;
	                if (text.charAt(i + j) != pattern.charAt(j)) {
	                    break;
	                }
	            }

	            // If the pattern is found, print the index
	            if (j == patternLength) {
	                System.out.println("Pattern found at index: " + i);
	            }
	        }

	        // Print the total number of comparisons made
	        System.out.println("Total comparisons made: " + comparisonCount);
	    }

	    public static void main(String[] args) {
	        String text = "ABABABCABABABCABABABC";
	        String pattern = "ABABC";

	        naivePatternSearch(text, pattern);
	    }
}
