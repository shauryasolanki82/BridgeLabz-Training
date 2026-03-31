package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	public static void insertionSort(int[] record) {
		int n=record.length;
		for(int i=1;i<n;i++) {
			int key=record[i];
			int j=i-1;
			while(j>=0 && record[j]>key) {
				record[j+1]=record[j];
				j--;
			}
			record[j+1]=key;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of employees: ");
		int numberOfEmployees=sc.nextInt();
		int[] record=new int[numberOfEmployees];
		System.out.println("Enter the employee's id: ");
		for(int i=0;i<numberOfEmployees;i++) {
			record[i]=sc.nextInt();
		}
		insertionSort(record);
		System.out.println(Arrays.toString(record));
		sc.close();
	}

}
