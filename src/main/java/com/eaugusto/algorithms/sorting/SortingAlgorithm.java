package com.eaugusto.algorithms.sorting;

public interface SortingAlgorithm {
	void sort(int[] array);
	default void swap(int[] array, int index, int index2) {
		int temp = array[index];
		array[index] = array[index2];
		array[index2] = temp;
	}
}