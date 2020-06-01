package com.sort;

import java.util.Arrays;

import com.util.SortUtil;

/**
 * 快速排序
 * 
 * @author pang
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = { 3, 4, 9, 6, 5, 4, 8, 1, 10, -1, 0 };
		QuickSort.quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * 对数组进行排序
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		sort(arr, 0, arr.length - 1);
	}

	/**
	 * 排序
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			sort(arr, left, pivot - 1);
			sort(arr, pivot, right);
		}

	}

	/**
	 * 获取一个基准值的索引
	 * 
	 * @param arr
	 *            待排序的数组
	 * @param left
	 *            第一个元素的索引
	 * @param right
	 *            最后一个元素的位置
	 * @return
	 */
	private static int partition(int[] arr, int left, int right) {
		// 选择基准值
		int mid = (left + right) / 2;
		int pivot = arr[mid];

		while (left <= right) {
			while (SortUtil.less(arr[left], pivot)) {
				left++;
			}
			while (SortUtil.less(pivot, arr[right])) {
				right--;
			}
			if (left <= right) {
				SortUtil.swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
}
