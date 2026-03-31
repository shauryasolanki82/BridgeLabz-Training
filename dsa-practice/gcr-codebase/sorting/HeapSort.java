package sorting;
import java.util.*;
public class HeapSort {
	static void heapsort(int[] arr,int n)
	{
		for(int i=n/2-1;i>=0;i--)
		{
			makeheap(arr,n,i);
		}
		for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            makeheap(arr, i, 0);
        }
    }
	static void makeheap(int[] arr,int size,int i)
	{
		int biggest=i;
		int leftchild=2*i+1;
		int rightchild=2*i+2;
		if(leftchild<size&&arr[leftchild]>arr[biggest])
			biggest=leftchild;
		if(rightchild<size&&arr[rightchild]>arr[biggest])
			biggest=rightchild;
		if(biggest!=i)
		{
			int temp=arr[biggest];
			arr[biggest]=arr[i];
			arr[i]=temp;
			
			makeheap(arr,size,biggest);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of employees");
		int n=sc.nextInt();
		int[] emp=new int[n];
		for(int i=0;i<n;i++)
		{
			emp[i]=sc.nextInt();
		}
		heapsort(emp,n);
		System.out.print(Arrays.toString(emp));
		sc.close();
	}

}
