import java.util.*;

class PriorityQueue {

	static int[] heap = new int[50];
	static int heap_size = -1;

	public static int parent(int i) {
		return (i - 1) / 2;
	}

	public static int leftChild(int i) {
		return ((2 * i) + 1);
	}

	public static int rightChild(int i) {
		return ((2 * i) + 2);
	}

	static void shiftUp(int i) {
		while (i > 0 && heap[parent(i)] < heap[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	public static void maxHeapify(int i) {
		int lc = 2 * i + 1;
		int rc = 2 * i + 2;
		int largest = i;
		if (lc <= heap_size && heap[lc] > heap[i]) {
			largest = lc;
		}
		if (rc <= heap_size && heap[rc] > heap[largest]) {
			largest = rc;
		}

		if (largest != i) {
			swap(largest, i);
			maxHeapify(largest);
		}
	}

	public static void insert(int x) {
		heap_size++;
		heap[heap_size] = x;
		shiftUp(heap_size);
	}

	public static int heap_Extract_Max() {
		if (heap_size < 1) {
			System.out.println("Heap Underflow");
			return Integer.MIN_VALUE;
		}
		int max = heap[0];
		heap[0] = heap[heap_size];
		heap_size--;
		maxHeapify(0);
		return max;
	}

	public static void heap_Increase_Key(int i, int key) {
		if (key < heap[i]) {
			System.out.println("New Key smaller than current key");
			return;
		}
		heap[i] = key;
		shiftUp(i);
	}

	public static int heap_Maximum() {
		return heap[0];
	}

	public static void remove(int i) {
		heap[i] = heap_Maximum() + 1;
		shiftUp(i);
		heap_Extract_Max();
	}

	public static void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public static void main(String[] args) {
		insert(40);
		insert(19);
		insert(14);
		insert(67);
		insert(36);
		insert(1);
		insert(16);
		insert(27);
		insert(2);
		insert(2);

		int i = 0;
		System.out.print("Priority Queue : ");
		while (i <= heap_size) {
			System.out.print(heap[i] + " ");
			i++;
		}
		System.out.println();
		System.out.print("Node with maximum priority : " + heap_Extract_Max() + "\n");
		System.out.print("Priority queue after " + "extracting maximum : ");
		int j = 0;
		while (j <= heap_size) {
			System.out.print(heap[j] + " ");
			j++;
		}
		System.out.println();
		heap_Increase_Key(2, 49);
		System.out.print("Priority queue after priority change : ");
		int k = 0;
		while (k <= heap_size) {
			System.out.print(heap[k] + " ");
			k++;
		}
		System.out.println();
		remove(3);
		System.out.print("Priority queue after " + "removing the element : ");
		int l = 0;
		while (l <= heap_size) {
			System.out.print(heap[l] + " ");
			l++;
		}
	}
}
