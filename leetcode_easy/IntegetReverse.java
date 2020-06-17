package leetcode_easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1: 输入: 123 输出: 321  
 * 
 * 示例 2: 输入: -123 输出: -321
 * 
 * 示例 3: 输入: 120 输出: 21 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2147483648, 
 * 2147483647]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 * @author pang
 *
 */
public class IntegetReverse {

	public static void main(String[] args) {
		System.out.println(reverse(1234523));
		System.out.println(reverse(-10293134));
		System.out.println(reverse(1234567899));
	}

	/**
	 * 反转函数
	 * 
	 * @param x
	 *            传入的int类型的值
	 * @return 反转之后的结果
	 */
	public static int reverse(int x) {
		int reverse = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			// 判断溢出问题
			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			reverse = reverse * 10 + pop;
		}
		return reverse;
	}
}
