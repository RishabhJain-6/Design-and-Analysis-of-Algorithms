import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BucketSort {
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		float[] arr = new float[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextFloat();
		}

		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr) + "\n");

		bucketSort(arr);

		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
	}

	public static void bucketSort(float[] A) {
		if (A.length > 1) {
			ArrayList<ArrayList<Float>> bucket = new ArrayList<>();
			for (int i = 0; i < A.length; i++) {
				bucket.add(i, new ArrayList<Float>());
			}
			for (int i = 0; i < A.length; i++) {
				int bidx = (int) (A[i] * A.length);
				bucket.get(bidx).add(A[i]);
			}
			for (int i = 0; i < A.length; i++) {
				Collections.sort(bucket.get(i));
			}
			int idx = 0;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < bucket.get(i).size(); j++) {
					A[idx++] = bucket.get(i).get(j);
				}
			}
		}
	}
}
