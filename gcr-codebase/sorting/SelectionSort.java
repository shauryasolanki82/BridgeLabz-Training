package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void selectionSort(int[] scores) {
		int n=scores.length;
		for(int i=0;i<n-1;i++) {
			int minIdx=i;
			for(int j=i+1;j<n;j++) {
				if(scores[j]<scores[minIdx]) {
					minIdx=j;
				}
			}
			int temp=scores[i];
			scores[i]=scores[minIdx];
			scores[minIdx]=temp;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Number of Students: ");
		int numberOfStudents=sc.nextInt();
		int[] scores=new int[numberOfStudents];
		System.out.println("Enter the scores of Students: ");
		for(int i=0;i<numberOfStudents;i++) {
			scores[i]=sc.nextInt();
		}
		selectionSort(scores);
		System.out.println(Arrays.toString(scores));
		sc.close();
	}

}
