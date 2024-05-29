package tasks;

public class UniqueElements {
 
	  public static int[] findUniqueElements(int[] nums) {
	        // Step 1: XOR all elements to get xor of two unique numbers
	        int xor = 0;
	        for (int num : nums) {
	            xor ^= num;
	        }

	        // Step 2: Find a set bit in the xor result
	        int setBit = xor & ~(xor - 1);

	        // Step 3: Divide the array into two groups and XOR elements within each group
	        int unique1 = 0;
	        int unique2 = 0;
	        for (int num : nums) {
	            if ((num & setBit) != 0) {
	                unique1 ^= num;
	            } else {
	                unique2 ^= num;
	            }
	        }

	        return new int[]{unique1, unique2};
	    }

	    public static void main(String[] args) {
	        int[] nums = {1, 2, 3, 2, 1, 4};
	        int[] uniqueElements = findUniqueElements(nums);
	        System.out.println("The two unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
	    }

}
