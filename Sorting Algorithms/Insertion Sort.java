import java.util.*;

public class InsertionSort
{
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		int[] arr = new int[n];
		for (int i=0;i<n;i++)
		{
		    arr[i]=rand.nextInt(100);
		}
		
		System.out.println("Input Array->");
		System.out.println(Arrays.toString(arr)+"\n");
		
		insertion_Sort(arr);
		
		System.out.println("\nSorted Array->");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertion_Sort(int[] arr)
	{
	    System.out.print("No of comparisons for each pass: ");
	    int tcom=1;
	    for (int j=1;j<arr.length;j++)
	    {
	        int key = arr[j];
	        int i=j-1;
	        int ncom=1;
	        while (i>=0 && arr[i]>key)
	        {
	            arr[i+1]=arr[i];
	            i--;
	            ncom++;
	        }
	        System.out.print(ncom+" ");
	        arr[i+1]=key;
	        tcom+=ncom;
	    }
	    System.out.println("\nTotal Comparisons: "+tcom);
	}
}
