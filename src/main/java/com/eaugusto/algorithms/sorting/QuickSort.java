package com.eaugusto.algorithms.sorting;

public class QuickSort implements SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private void quickSort(int[] array, int first, int last) {
		if(first < last) {
			int p = partition(array, first, last);
			quickSort(array, first, p);
			quickSort(array, p + 1, last);
		}
	}
	
	private int partition(int[] array, int first, int last) {
		int pivot = array[(first + last)/2];
		int i = first - 1;
		int j = last + 1;
		while(true) {
			do {
				i++;
			} while(array[i] < pivot);
			do {
				j--;
			} while(array[j] > pivot);
			if(i >= j) {
				return j;
			}
			
			swap(array, i, j);
		}
	}
}