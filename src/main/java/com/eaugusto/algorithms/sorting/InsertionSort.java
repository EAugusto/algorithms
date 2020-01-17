package com.eaugusto.algorithms.sorting;

public class InsertionSort implements SortingAlgorithm {
	
	@Override
	public void sort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int j = i;
			while(j > 0 && array[j] < array[j-1]) {
				swap(array, j, j-1);
				j--;
			}
		}
	}
}