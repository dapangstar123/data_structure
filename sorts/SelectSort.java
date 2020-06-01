package com.sort;

import java.util.Arrays;

import com.util.SortUtil;

/**
 * 选择排序
 * 
 * @author pang
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr1 = { 4, 23, 6, 78, 1, 54, 231, 9, 12, -1, 4 };
		selectSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}

	/**
	 * 选择排序
	 * 
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (SortUtil.more(arr[minIndex], arr[j])) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				SortUtil.swap(arr, i, minIndex);
			}
		}
	}
}
