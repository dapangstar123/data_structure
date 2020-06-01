package com.sort;

import java.util.Arrays;

import com.util.SortUtil;

/**
 * 插入排序 将一个记录插入到已排好序的序列中，从而得到一个新的有序序列 将序列的第一个数据看成是一个有序的子序列，
 * 然后从第二个记录逐个向该有序的子序列进行有序的插入，直至整个序列有序
 * 
 * @author pang
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr1 = { 4, 23, 6, 78, 1, 54, 231, 9, 12, -1, 4 };
		insertSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}

	/**
	 * 插入排序
	 * 
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; j--) {
				// 待排元素小于有序元素最大的元素，则插入
				if (SortUtil.less(arr[j], arr[j - 1])) {
					SortUtil.swap(arr, j - 1, j);
				}
			}

		}
	}
}
