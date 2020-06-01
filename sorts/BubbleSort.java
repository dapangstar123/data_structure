package com.sort;

import java.util.Arrays;

import com.util.SortUtil;

/**
 * 冒泡排序
 * 基本思想: 冒泡排序，类似于水中冒泡，较大的数沉下去，较小的数慢慢冒起来，
 * 假设从小到大，即为较大的数慢慢往后排，较小的数慢慢往前排。
 * @author pang
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr1 = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}

	public static void bubbleSort(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (SortUtil.more(arr[j], arr[j + 1])) {
					SortUtil.swap(arr, j, j + 1);
				}
			}
		}
	}
}
