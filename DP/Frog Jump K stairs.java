import java.util.* ;
import java.io.*; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int k = sc.nextInt();
        int[] heights = new int[a];
        for (int i = 0; i < a; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(frogJump(a,  heights, k));
    }

    public static int frogJump(int n, int heights[], int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp, k);
    }

    static int solve(int n, int[] heights, int[] dp, int k) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                minEnergy = Math.min(minEnergy, solve(n - i, heights, dp, k) + Math.abs(heights[n] - heights[n - i]));
            }
        }
        dp[n] = minEnergy;
        return dp[n];
    }
}
