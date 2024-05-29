package tasks;

public class StringOperations {

	public static String processStrings(String str1, String str2, int length) {
        // Concatenate the two strings
        String concatenated = str1 + str2;

        // Reverse the concatenated string
        String reversed = new StringBuilder(concatenated).reverse().toString();

        // Handle edge cases
        if (reversed.isEmpty() || length <= 0) {
            return "";
        }
        if (length >= reversed.length()) {
            return reversed;
        }

        // Extract the middle substring of the given length
        int start = (reversed.length() - length) / 2;
        return reversed.substring(start, start + length);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(processStrings("hello", "world", 5)); // Expected: "dlrow"
        System.out.println(processStrings("hello", "world", 10)); // Expected: "dlrowolleh"
        System.out.println(processStrings("hello", "", 3)); // Expected: "oll"
        System.out.println(processStrings("", "world", 2)); // Expected: "dl"
        System.out.println(processStrings("hello", "world", 0)); // Expected: ""
        System.out.println(processStrings("", "", 5)); // Expected: ""
    }

}
