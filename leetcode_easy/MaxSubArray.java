package leetcode_easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * @author pang
 *
 */
public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		// 滚动数组
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] + nums[i - 1] > nums[i]) {
				nums[i] = nums[i] + nums[i - 1];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}
}
