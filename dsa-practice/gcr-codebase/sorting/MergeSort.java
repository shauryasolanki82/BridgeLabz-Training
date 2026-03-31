package sorting;
import java.util.Arrays;
import java.util.Scanner;
public class MergeSort {
	public static void mergeSort(int[] arr, int start, int end) {
		if(start<end) {
			int mid = start+(end-start)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	public static void merge(int[] arr, int start, int mid, int end) {
		int n1 = mid-start+1;
		int n2 = end-mid;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		System.arraycopy(arr, start , arr1, 0, n1);
		System.arraycopy(arr, mid+1, arr2, 0, n2);
		int i=0,j=0,k=start;
		while(i<n1 && j<n2) {
			if(arr2[j]>=arr1[i]) {
				arr[k++] = arr1[i++];
			}
			else if(arr2[j]<arr1[i]) {
				arr[k++] = arr2[j++];
			}
		}
		while (i < n1) arr[k++] = arr1[i++];
        while (j < n2) arr[k++] = arr2[j++];

	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Books");
        int noOfBooks = sc.nextInt();
        int[] books = new int[noOfBooks];
        System.out.println("Enter the prices of books.");
        for(int i=0;i<noOfBooks;i++) {
        	books[i] = sc.nextInt();
        }
        mergeSort(books, 0, books.length-1);
        	System.out.println(Arrays.toString(books));
        	sc.close();
    }
}
