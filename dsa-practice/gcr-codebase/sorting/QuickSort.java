package sorting;

import java.util.Scanner;

public class QuickSort {

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);

            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];  // pivot
        int i = low - 1;        // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of products");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the price of the product");
        for(int i=0;i<n;i++) {
        	arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr)
            System.out.print(num + " ");
        sc.close();
    }
}

