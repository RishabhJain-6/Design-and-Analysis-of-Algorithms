
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
		}

		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr) + "\n");

		selectionSort(arr);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr) {
		System.out.print("No of comparisons for each pass: ");
		int tcom = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			int min_idx = i;
			int ncom = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_idx])
					min_idx = j;
				ncom++;
			}
			tcom += ncom;
			if (min_idx != i) {
				int temp = arr[i];
				arr[i] = arr[min_idx];
				arr[min_idx] = temp;
			}
			System.out.print(ncom + " ");
		}
		System.out.println("\nTotal Comparisons: " + tcom);
	}
}

