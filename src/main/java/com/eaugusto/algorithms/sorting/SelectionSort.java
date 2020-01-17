package com.eaugusto.algorithms.sorting;

public class SelectionSort implements SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[min]) {
					swap(array, min, j);
				}
			}
		}
	}
}