package bad;

import java.util.ArrayList;
import java.util.Collections;

import bad.sort.BadSort;

public class Main {
	public static void main(String[] args) {
		int size = 7;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < size; i++) {
			list.add(i*i);
		}
		Collections.shuffle(list);
		int[] a = new int[size];
		for(int i = 0; i < size; i++) {
			a[i] = list.get(i);
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		long start = System.currentTimeMillis();
		int[] sorted = BadSort.sort(a);
		long end = System.currentTimeMillis();
		long elapsed = end - start;
		for(int i = 0; i < size; i++) {
			System.out.print(sorted[i] + ", ");
		}
		System.out.println();
		System.out.println("Sorting " + size + " elements took " + elapsed + " milliseconds.");
	}
}
