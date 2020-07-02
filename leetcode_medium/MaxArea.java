package leetcode_medium;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线
 * i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * @author pang
 *
 */
public class MaxArea {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	/**
	 * 双指针解法
	 * 
	 * 考虑第一步，假设当前左指针和右指针指向的数分别为 x 和 y，不失一般性，我们假设 x ≤ y。同时，两个指针之间的距离为
	 * t。那么，它们组成的容器的容量为：
	 * 
	 * min(x, y) * t = x * t
	 * 
	 * 我们可以断定，如果我们保持左指针的位置不变，那么无论右指针在哪里，这个容器的容量都不会超过 x * t 了。
	 * 注意这里右指针只能向左移动，因为我们考虑的是第一步，也就是 指针还指向数组的左右边界的时候。
	 * 无论我们怎么移动右指针，得到的容器的容量都小于移动前容器的容量。也就是说，这个左指针对应的数不会作为容器的边界了，
	 * 那么我们就可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针于原先的右指针之间的左右位置，才可能会作为容器的边界。
	 * 
	 * @param height
	 *            传入的数组
	 * @return 返回最大面积
	 */
	public static int maxArea(int[] height) {
		if (height.length == 0 || height.length == 1) {
			return 0;
		}

		// 左指针
		int left = 0;
		// 右指针
		int right = height.length - 1;
		int max = 0;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			max = Math.max(max, area);
			if (height[left] < height[right]) {
				++left;
			} else {
				--right;
			}
		}
		return max;
	}

	/**
	 * 暴力解法(效率较低)
	 * 
	 * @param height
	 *            传入的数组
	 * @return 返回最大面积
	 */
	public static int maxArea2(int[] height) {
		if (height.length == 0 || height.length == 1) {
			return 0;
		}

		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return max;
	}
}
