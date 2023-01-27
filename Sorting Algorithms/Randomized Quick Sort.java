import java.util.Arrays;
import java.util.Random;

public class RandomQuickSort {
	static int count = 0;
	static Random rand = new Random();

	public static void main(String[] args) {
		int n = rand.nextInt(10);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
		}

		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr) + "\n");

		quickSort(arr, 0, n - 1);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
		System.out.println("\nTotal no of comparisons: " + count);
	}

	public static void quickSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = partiton_r(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
			count++;
		} else
			count++;
	}

	public static int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (arr[j] <= x) {
				i++;
				swap(arr, i, j);
				count++;
			} else
				count++;
		}
		count++;
		swap(arr, i + 1, r);
		return i + 1;
	}

	public static int partiton_r(int[] arr, int p, int r) {
		int idx = (p) + (int)(Math.random() * (r - p + 1));
		swap(arr, idx, r);
		return partition(arr, p, r);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
