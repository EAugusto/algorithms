package com.eaugusto.algorithms;

import java.io.FileNotFoundException;
import java.util.Random;

import com.eaugusto.algorithms.sorting.BubbleSort;
import com.eaugusto.algorithms.sorting.DualPivotQuickSort;
import com.eaugusto.algorithms.sorting.InsertionSort;
import com.eaugusto.algorithms.sorting.QuickSort;
import com.eaugusto.algorithms.sorting.SelectionSort;
import com.eaugusto.algorithms.sorting.SortingAlgorithm;

public class SortingComparingMain {

	private static SortingAlgorithm[] algorithms;
	private static int arraySize = 1_000_000;

	static {
		algorithms = new SortingAlgorithm[] {
				new BubbleSort(), 
				new SelectionSort(), 
				new InsertionSort(), 
				new DualPivotQuickSort(),
				new QuickSort(),
		};
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		for(SortingAlgorithm algorithm : algorithms) {
			Random random = new Random();
			int[] array = new int[arraySize];
			for(int i = 0; i < arraySize; i++) array[i] = random.nextInt();
			long start = System.currentTimeMillis();
			algorithm.sort(array);
			long end = System.currentTimeMillis();
			System.out.println("The " + algorithm.getClass().getSimpleName() + " algorithm took " + (end - start) + " millis");
		}
	}
}