package com.sort;

import java.util.Arrays;
import java.util.Random;

import com.util.SortUtil;

/**
 * 猴子排序
 * 
 * @author pang
 *
 */
public class BogoSort {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 9, 6, 5 };
		BogoSort.bogoSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static final Random random = new Random();

	public static void bogoSort(int[] arr) {
		while (!isSorted(arr)) {
			nextShuffle(arr);
		}
	}

	/**
	 * 判断数组是否是有序的
	 * 
	 * @param arr
	 * @return
	 */
	private static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (SortUtil.more(arr[i], arr[i + 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 随机打乱数组
	 * 
	 * @param arr
	 */
	public static void nextShuffle(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int randomIndex = i + random.nextInt(length - i);
			SortUtil.swap(arr, i, randomIndex);
		}
	}

}
