
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
		}

		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr) + "\n");

		bubbleSort(arr);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		System.out.print("No of comparisons for each pass: ");
		int tcom = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			int ncom = 1;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				ncom++;
			}
			System.out.print(ncom + " ");
			tcom += ncom;
		}
		System.out.println("\nTotal Comparisons: " + tcom);
	}
}

