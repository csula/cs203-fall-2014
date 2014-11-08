package lab7;

public class BubbleSort {

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void shuffle( int[] a ) {
		for (int i = 0; i < a.length; i++) {
			int j = (int) (Math.random() * a.length);
			swap(a, i, j);
		}
	}

	public static void print( int[] a ) {
		for (int i : a ) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public static void bubbleSort(int[] a) {
		int left = 0;
		int right = a.length - 1;
		for (int i = right; i > left; i--) {
			for (int j = left; j < i; j++) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		print(a);
		shuffle(a);
		print(a);
		bubbleSort(a);
		print(a);		
	}
}
