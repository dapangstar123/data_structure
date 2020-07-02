package leetcode_easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 
 * 
 * 示例 1: 输入: a = "11", b = "1" 输出: "100"
 * 
 * 示例 2: 输入: a = "1010", b = "1011" 输出: "10101"
 * 
 * 
 * @author pang
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("1010", "1011"));
		System.out.println(addBinary2("1010", "1011"));
	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		// 获取两个字符串中最长的长度
		int n = a.length() >= b.length() ? a.length() : b.length();
		// 定义进位
		int carry = 0;
		for (int i = 0; i < n; i++) {
			carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
			carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
			sb.append((char) (carry % 2 + '0'));
			// 重置进位
			carry /= 2;
		}
		// 判断最后一次进位
		if (carry > 0) {
			sb.append('1');
		}
		return sb.reverse().toString();
	}

	public static String addBinary2(String a, String b) {
		return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
	}
}
