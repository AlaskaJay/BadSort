package bad.sort;

import java.util.ArrayList;

public class BadSort {
	public static int[] sort(int[] a) {
		int[][] combos = combinations(a.length);
		int[] test = new int[a.length];
		
		for(int i = 0; i < combos.length; i++) {
			// System.out.println("Testing combination: " + i);
			test = new int[a.length];
			for(int j = 0; j < a.length; j++) {
				test[j] = a[combos[i][j]];
			}
			if(sorted(test)) {
				break;
			}
		}
		return test;
	}
	
	private static int[][] combinations(int size) {
		System.out.println("Generating all combinations");
		ArrayList<ArrayList<Integer>> list = combinationHelper(new ArrayList<Integer>(), size);
		
		System.out.println("Removing invalid combinations");
		int i = 0;
		while(i < list.size()) {
			if(!validCombination(list.get(i).toArray())){
				list.remove(i);
			} else {
				i++;
			}
		}
		
		System.out.println("Assigning all combinations to int[][]");
		int[][] a = new int[factorial(size)][size];
		for(i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = list.get(i).get(j);
			}
		}
		return a;
	}
	
	private static ArrayList<ArrayList<Integer>> combinationHelper(ArrayList<Integer> list, int size) {
		// System.out.println("Call to combinationHelper generating size " + (size+1) + " ArrayLists");
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(list.size() < size) {
			for(int i = 0; i < size; i++) {
				ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
				clone.add(i);
				result.addAll(combinationHelper(clone, size));
			}
		} else {
			result.add(list);
		}
		return result;
	}
	
	private static int factorial(int size) {
		int factorial = 1;
		for(int i = 2; i <= size; i++) {
			factorial *= i;
		}
		return factorial;
	}
	
	
	private static boolean sorted(int[] a) {
		for(int i = 1; i < a.length; i++) {
			// System.out.print(a[i-1] + ", ");
			if(a[i-1] > a[i]) {
				// System.out.println(a[i]);
				return false;
			}
		}
		// System.out.println(a[a.length-1]);
		return true;
	}
	
	private static boolean validCombination(Object[] objects) {				
		boolean[] b = new boolean[objects.length];
		/*
		System.out.print("Testing: ");
		for(int i = 0; i < objects.length; i++) 
			System.out.print(objects[i] + ", ");
		System.out.println();
		*/
		for(int i = 0; i < objects.length; i++) {
			if(b[(int) objects[i]]) {
				return false;
			} else {
				b[(int) objects[i]] = true;
			}
		}
		return true;
	}
}
