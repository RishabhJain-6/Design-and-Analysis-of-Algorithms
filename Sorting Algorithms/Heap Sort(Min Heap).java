import java.util.Arrays;
import java.util.Random;

public class MinHeapSort {
	static int heap_size = 0;
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

		heapSort(arr);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));

		System.out.println("\n\nTotal number of comparisons: " + count);
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void minHeapify(int[] A, int i) {
		int lc = 2 * i + 1;
		int rc = 2 * i + 2;
		int smallest = i;
		if (lc <= heap_size && A[lc] < A[i]) {
			smallest = lc;
			count += 2;
		}

		if (rc <= heap_size && A[rc] < A[smallest]) {
			smallest = rc;
			count += 2;
		}
		count++;

		if (smallest != i) {
			swap(A, smallest, i);
			count++;
			minHeapify(A, smallest);
		} else
			count++;
	}

	public static void buildMinHeap(int[] A) {
		heap_size = A.length - 1;
		for (int i = A.length / 2; i >= 0; i--) {
			minHeapify(A, i);
			count++;
		}
		count++;
	}

	public static void heapSort(int[] A) {
		buildMinHeap(A);
		for (int i = A.length - 1; i >= 0; i--) {
			swap(A, 0, i);
			count++;
			heap_size--;
			minHeapify(A, 0);
		}
		count++;
	}
}
