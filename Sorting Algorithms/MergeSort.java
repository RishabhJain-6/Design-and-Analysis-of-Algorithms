import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	static int count = 0;

	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
		}

		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr) + "\n");

		mergeSort(arr, 0, arr.length - 1);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));

		System.out.println("\n\nTotal number of comparisons: " + count);
	}

	public static void mergeSort(int[] arr, int p, int r) {
		if (p < r) {
			count++;
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		} else
			count++;
	}

	public static void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1 + 1];
		int R[] = new int[n2 + 1];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0, j = 0;
		int k = l;
		while (k <= r) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			count++;
			k++;
		}
		count++;
	}
}
