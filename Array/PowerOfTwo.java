class Solution {

    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}


// 8=1000
// n-1 = 7 = 0111
// 1000 & 0111 wil give the answer as 0 so, true will return.


class Solution {
    public static boolean isPowerofTwo(long n) {
        if (n <= 0) {
            return false;
        }
        
        // Calculate the logarithm of n base 2
        double logBase2 = Math.log(n) / Math.log(2);

        return logBase2 == Math.floor(logBase2);
    }
}
