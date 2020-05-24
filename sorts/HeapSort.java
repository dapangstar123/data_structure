package com.heap;

import java.util.Arrays;

/**
 * 堆排序
 * 
 * @author pang
 *
 */
public class HeapSort {

	/**
	 * 堆排序
	 * 
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
		int size = arr.length;
		// 1.构造大根堆
		heapInsert(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = size - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}

	/**
	 * 将剩余的数构造成大根堆（通过顶端的数下降）
	 * 
	 * @param arr
	 * @param index
	 * @param size
	 */
	public static void heapify(int[] arr, int index, int size) {
		// 获取左右孩子的索引
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largeIndex = index;

		while (left < size) {
			// 先判断左右孩子和父亲节点的大小
			if (arr[left] > arr[index]) {
				largeIndex = left;
			}
			if (arr[right] > arr[largeIndex] && right < size) {
				largeIndex = right;
			}

			if (largeIndex != index) {
				swap(arr, largeIndex, index);
			} else {
				break;
			}
			// 重新指定索引
			index = largeIndex;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}

	}

	/**
	 * 构造大根堆
	 * 
	 * @param arr
	 */
	public static void heapInsert(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// 当前插入的索引
			int curIndex = i;
			// 当前插入的父亲的索引
			int farIndex = (curIndex - 1) / 2;
			// 如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
			// 然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
			while (arr[curIndex] > arr[farIndex]) {
				swap(arr, curIndex, farIndex);
				curIndex = farIndex;
				farIndex = (curIndex - 1) / 2;
			}
		}

	}

	/**
	 * 交换数组中两个变量的值
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void swap2(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];

	}

	public static void swap3(int[] arr, int i, int j) {
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}

}
