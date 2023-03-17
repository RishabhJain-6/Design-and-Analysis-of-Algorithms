import java.util.Scanner;

public class Randomised_Select {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int pos = scn.nextInt();
		System.out.println(pos + "th smallest number is: " + randomisedSelect(arr, 0, n - 1, pos));
	}

	public static int randomisedSelect(int[] arr, int p, int r, int i) {
		if (p == r)
			return arr[p];
		int q = randomised_partition(arr, p, r);
		int k = q - p + 1;
		if (i == k)
			return arr[q];
		else if (i < k)
			return randomisedSelect(arr, p, q - 1, i);
		else
			return randomisedSelect(arr, q + 1, r, i - k);
	}

	public static int randomised_partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (arr[j] <= x) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, r);
		return i + 1;
	}

	public static int partiton_r(int[] arr, int p, int r) {
		int idx = (p) + (int) (Math.random() * (r - p + 1));
		swap(arr, idx, r);
		return randomised_partition(arr, p, r);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
