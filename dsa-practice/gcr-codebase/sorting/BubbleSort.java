package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	public static void bubbleSort(int[] marks) {
		int n=marks.length;
		boolean swapped;
		for(int i=0;i<n-1;i++) {
			swapped=false;
			for(int j=0;j<n-i-1;j++) {
				if(marks[j]>marks[j+1]) {
					int temp=marks[j];
					marks[j]=marks[j+1];
					marks[j+1]=temp;
					swapped=true;
				}
			}
			if(!swapped) break;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int numberOfStudents=sc.nextInt();
		int[] marks=new int[numberOfStudents];
		System.out.println("Enter the marks of students:");
		for(int i=0;i<numberOfStudents;i++) {
			marks[i]=sc.nextInt();
		}
		bubbleSort(marks);
		System.out.println(Arrays.toString(marks));
		sc.close();
	}
}
