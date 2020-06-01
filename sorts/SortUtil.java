package com.util;

/**
 * 排序工具类
 * 
 * @author pang
 *
 */
public class SortUtil {

	/**
	 * 检查第一个参数是否小于第二个数
	 * 
	 * @param v
	 * @param w
	 * @return true 如果第一个参数小于第二个数，返回true
	 */
	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 检查第一个参数是否大于第二个数
	 * 
	 * @param v
	 * @param w
	 * @return true 如果第一个参数大于第二个数据，返回true
	 */
	public static <T extends Comparable<T>> boolean more(T v, T w) {
		return v.compareTo(w) > 0;
	}

	/**
	 * 交换两个值的大小
	 * 
	 * @param a
	 * @param b
	 */
	public static void swap2(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	public static void swap3(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
	}

	public static void swap4(int a, int b) {
		a ^= b;
		b ^= a;
		a ^= b;
	}

	/**
	 * 交换数组中的两个数的大小
	 * 
	 * @param arr
	 * @param x
	 * @param y
	 */
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
