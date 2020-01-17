package com.eaugusto.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.eaugusto.algorithms.sorting.BubbleSort;
import com.eaugusto.algorithms.sorting.InsertionSort;
import com.eaugusto.algorithms.sorting.SelectionSort;
import com.eaugusto.algorithms.sorting.SortingAlgorithm;

public class SortingComparingMain {
	
	private static final SortingAlgorithm[] algorithms = new SortingAlgorithm[3];
	private static int arraySize = 100_000;

	static {
		algorithms[0] = new BubbleSort();
		algorithms[1] = new SelectionSort();
		algorithms[2] = new InsertionSort();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		try(Scanner scanner = new Scanner(new FileInputStream("src/main/resources/unordered-array_1_000_000.txt"));) {
			for(SortingAlgorithm algorithm : algorithms) {
				int[] array = new int[arraySize];
				for(int i = 0; i < arraySize; i++) array[i] = scanner.nextInt();
				long start = System.currentTimeMillis();
				algorithm.sort(array);
				long end = System.currentTimeMillis();
				System.out.println("The " + algorithm.getClass().getName() + " algorithm took " + (end - start) + " millis");
			}
		}
	}
}