import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int W = scn.nextInt();
//		int[] weight = new int[n];
//		int[] price = new int[n];
//		for (int i = 0; i < n; i++) {
//			weight[i] = scn.nextInt();
//			price[i] = scn.nextInt();
//		}
		int n = 4;
		int W = 8;
		int[] weight = { 2, 3, 4, 5 };
		int[] price = { 1, 2, 5, 6 };
		Integer[][] dp = new Integer[n + 1][W + 1];
		System.out.println(knapsack_REC(n, W, weight, price));
		System.out.println(knapsack_TD(n, W, weight, price, dp));
		System.out.println(knapsack_BU(W, weight, price));
	}

	public static int knapsack_BU(int W, int[] wt, int[] price) {
		int n = wt.length;
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 1; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (wt[i - 1] > w)
					dp[i][w] = dp[i - 1][w];
				else
					dp[i][w] = Math.max(dp[i - 1][w], price[i - 1] + dp[i - 1][w - wt[i - 1]]);
			}
		}
		return dp[n][W];
	}

	public static int knapsack_TD(int idx, int W, int[] wt, int[] price, Integer[][] dp) {
		if (idx == 0 || W == 0)
			return 0;

		if (dp[idx][W] != null)
			return dp[idx][W];

		if (wt[idx - 1] > W) {
			dp[idx][W] = knapsack_TD(idx - 1, W, wt, price, dp);
			return dp[idx][W];
		} else {
			dp[idx][W] = Math.max(knapsack_TD(idx - 1, W, wt, price, dp),
					price[idx - 1] + knapsack_TD(idx - 1, W - wt[idx - 1], wt, price, dp));
			return dp[idx][W];
		}
	}

	public static int knapsack_REC(int idx, int W, int[] wt, int[] price) {
		if (idx == 0 || W == 0)
			return 0;

		if (wt[idx - 1] > W)
			return knapsack_REC(idx - 1, W, wt, price);
		else
			return Math.max(knapsack_REC(idx - 1, W, wt, price),
					price[idx - 1] + knapsack_REC(idx - 1, W - wt[idx - 1], wt, price));
	}
}
