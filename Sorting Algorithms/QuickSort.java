import java.util.Arrays;
import java.util.Random;

public class QuickSort {
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

		quickSort(arr, 0, n - 1);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
		System.out.println("\nTotal no of comparisons: " + count);
	}

	public static void quickSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = partition(arr, p, r);
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

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
