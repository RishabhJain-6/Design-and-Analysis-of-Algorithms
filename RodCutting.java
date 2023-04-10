import java.util.Scanner;

public class RodCutting {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] price = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = scn.nextInt();
		}
		int rodlength = scn.nextInt();
		Integer[][] dp = new Integer[n + 1][n + 1];
		System.out.println(cutRod_TD(price, rodlength, n, dp));
//		System.out.println(cutRod_REC(price, rodlength, n - 1));
	}

	public static int cutRod_TD(int[] price, int size, int index, Integer[][] dp) {
		if (index == 0)
			return size * price[0];

		if (dp[index][size] != null)
			return dp[index][size];

		int notCut = cutRod_TD(price, size, index - 1, dp);
		int cut = Integer.MIN_VALUE;
		int rodlength = index + 1;
		if (rodlength <= size)
			cut = price[index] + cutRod_TD(price, size - rodlength, index, dp);
		dp[index][size] = Math.max(cut, notCut);
		return Math.max(cut, notCut);
	}

	public static int cutRod_REC(int[] price, int size, int index) {
		if (index == 0)
			return size * price[0];

		int notCut = cutRod_REC(price, size, index - 1);
		int cut = Integer.MIN_VALUE;
		int rodlength = index + 1;
		if (rodlength <= size)
			cut = price[index] + cutRod_REC(price, size - rodlength, index);
		return Math.max(cut, notCut);
	}
}
