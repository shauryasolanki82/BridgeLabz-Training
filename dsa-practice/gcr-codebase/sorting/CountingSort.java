package sorting;
import java.util.Arrays;

public class CountingSort {
	static int[] countingSort(int[] arr) {
		int max = arr[0];
		for(int i: arr) {
			if(i > max) {
				max = i;
			}
		}
		
		int[] count = new int[max+1];
		for(int i=0; i<=max; i++) {
			count[i] = 0;
		}
		for(int i : arr) {
			count[i]++;
		}
		for(int i=1; i<=max; i++) {
			count[i] = count[i]+count[i-1];
		}
		
		int[] result = new int[arr.length];
		for(int i = arr.length-1; i>=0; i--) {
			int v = arr[i];
			result[count[v]-1] = v;
			count[v]--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] age = {15, 12 ,44, 33 ,15 ,60 ,23 ,54};
		age = countingSort(age);
		System.out.println(Arrays.toString(age));
	}
}
