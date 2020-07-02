package leetcode_easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 
 * 示例 1： 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶
 * 
 * 示例 2： 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1
 * 阶
 * 
 * 
 * @author pang
 *
 */
public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(6));
		System.out.println(climbStairs(7));
	
	}
	
	// 可以看做就是求斐波那契数列
	public static int climbStairs(int n) {

		int x = 0; // 记录n-2
		int y = 0; // 记录n-1
		int result = 1;
		for (int i = 1; i <= n; i++) {
			// a, b = b, a + b
			x = y;
			y = result;
			result = x + y;
		}
		return result;
	}
}
