package leetcode_easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 
 * 
 * 示例 1: 输入: 121 输出: true
 * 
 * 示例 2: 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 示例 3: 输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * @author pang
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome2(2345432));
	}

	// 1. 将int转为字符串
	public static boolean isPalindrome(int x) {
		String str = Integer.toString(x);
		return str.equals(new StringBuffer(str).reverse().toString());
	}

	// 2. 不转字符串方式
	public static boolean isPalindrome2(int x) {
		// 如果是负数 ,并且最后一位是0 直接返回false
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		// 获取反转后的数字
		int reverse = 0;
		while (x > reverse) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		// 数字长度为偶数 x == reverse
		// 数字长度为奇数 x == reverse / 10
		return x == reverse || x == reverse / 10;
	}
}
