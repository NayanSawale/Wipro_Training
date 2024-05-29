package tasks;

public class BitManipulation {

	 // Method to count the number of set bits in an integer
    public static int countSetBits(int x) {
        int count = 0;
        while (x > 0) {
            count += x & 1;
            x >>= 1;
        }
        return count;
    }

    // Method to count the total number of set bits from 1 to n
    public static int totalSetBits(int n) {
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            totalCount += countSetBits(i);
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Total number of set bits from 1 to " + n + " is: " + totalSetBits(n));
    }

}
