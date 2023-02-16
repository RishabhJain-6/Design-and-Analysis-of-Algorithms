import java.util.Arrays;
import java.util.Random;

public class CountingSort {
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
		}

		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr) + "\n");

		countingSort(arr);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
	}

	public static void countingSort(int[] A) {
		int n = A.length;
		int k = maxm(A);
		int[] ans = new int[n];
		int[] count = new int[k + 1];
		Arrays.fill(count,0);
		for (int i = 0; i < n; i++) {
			count[A[i]]++;
		}
		for (int i = 1; i <= k; i++) {
			count[i] += count[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			ans[count[A[i]] - 1] = A[i];
			count[A[i]]--;
		}
		for (int i = 0; i < n; i++) {
			A[i] = ans[i];
		}
	}

	public static int maxm(int[] arr) {
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		return max;
	}
}
