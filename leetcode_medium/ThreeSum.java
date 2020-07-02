package leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 
 * @author pang
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums2 = { 0, 0, 0 };
		System.out.println(threeSum(nums));
		System.out.println(threeSum(nums2));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		// 排序
		Arrays.sort(nums);
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

		// 枚举第一个数a
		for (int first = 0; first < len; first++) {
			// 需要和上一次枚举的数不相同
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// 如果第一个数 > 0 则后面的数就不需要判断，直接结束循环
			if (nums[first] > 0) {
				break;
			}

			int third = len - 1;
			int target = -nums[first];
			// 枚举第二个数b
			for (int second = first + 1; second < len; second++) {
				// 需要和上一次枚举的数不相同
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// 需要保证 b 的指针在 c 的指针的左侧
				while (second < third && nums[second] + nums[third] > target) {
					--third;
				}
				if (second == third) {
					break;
				}
				if (nums[second] + nums[third] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					result.add(list);
				}
			}

		}
		return result;
	}
}
