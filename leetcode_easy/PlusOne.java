package leetcode_easy;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 
 * 示例 1: 输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。
 * 
 * 示例 2: 输入: [4,3,2,1] 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
 * 
 * 
 * @author pang
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4 };
		int[] nums2 = { 9, 9, 9, 9 };
		int[] nums3 = { 1, 2, 3, 9 };
		System.out.println(Arrays.toString(plusOne(nums1)));
		System.out.println(Arrays.toString(plusOne(nums2)));
		System.out.println(Arrays.toString(plusOne(nums3)));

	}

	public static int[] plusOne(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			nums[i]++;
			nums[i] = nums[i] % 10;
			if (nums[i] != 0) {
				return nums;
			}
		}
		// 如果数组里面都是9，则加1之后产生的进位会使数组越界，需要重新分配大小
		nums = new int[nums.length + 1];
		nums[0] = 1;
		return nums;
	}
}
