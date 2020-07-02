package leetcode_medium;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。  
 * 
 * 示例 1: 输入: "42" 输出: 42
 * 
 * 示例 2: 输入: " -42" 输出: -42 解释: 第一个非空白字符为 '-', 它是一个负号。  
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 
 * 示例 3: 输入: "4193 with words" 输出: 4193 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 
 * 示例 4: 输入: "words and 987" 输出: 0 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。 因此无法执行有效的转换。
 * 
 * 示例 5: 输入: "-91283472332" 输出: -2147483648 解释: 数字 "-91283472332" 超过 32
 * 位有符号整数范围。   因此返回 INT_MIN (−2^31) 。
 * 
 * 
 * @author pang
 *
 */
public class MyAtoi {

	public static void main(String[] args) {

		System.out.println(atoi("42"));
		System.out.println(atoi("-42"));
		System.out.println(atoi("4193 with words"));
		System.out.println(atoi("words and 987"));
		System.out.println(atoi("-91283472332"));
		System.out.println(atoi("  +-123"));
		System.out.println(atoi("  +0 123"));

		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println(atoi2("42"));
		System.out.println(atoi2("-42"));
		System.out.println(atoi2("4193 with words"));
		System.out.println(atoi2("words and 987"));
		System.out.println(atoi2("-91283472332"));
		System.out.println(atoi("  +-123"));
		System.out.println(atoi("  +0 123"));

		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println(atoi3("42"));
		System.out.println(atoi3("-42"));
		System.out.println(atoi3("4193 with words"));
		System.out.println(atoi3("words and 987"));
		System.out.println(atoi3("-91283472332"));
		System.out.println(atoi("  +-123"));
		System.out.println(atoi("  +0 123"));

	}

	/**
	 * 有限状态机模式算法
	 * 
	 * @param str
	 * @return
	 */
	public static int atoi(String str) {
		Automata automata = new Automata();
		for (char c : str.toCharArray()) {
			automata.get(c);
		}
		return automata.sign * (int) automata.result;
	}

	/**
	 * 正则表达式实现
	 * 
	 * @param str
	 * @return
	 */
	public static int atoi2(String str) {
		String pattern = "^\\s*([+-]?\\d+)";
		// 编译
		Pattern compile = Pattern.compile(pattern);
		// 匹配
		Matcher matcher = compile.matcher(str);
		if (!matcher.find()) {
			return 0;
		}
		BigInteger result = new BigInteger(matcher.group(1));
		if (result.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
			return Integer.MIN_VALUE;
		}
		if (result.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
			return Integer.MAX_VALUE;
		}
		return result.intValue();
	}

	/**
	 * 正常遍历
	 * 
	 * @param str
	 * @return
	 */
	public static int atoi3(String str) {
		int len = str.length();
		// 符号
		int sign = 1;
		// 结果
		int result = 0;
		int i = 0;

		// 空白字符处理
		while (i < len && str.charAt(i) == ' ') {
			i++;
		}
		if (i == len) {
			return 0;
		}
		// 符号处理
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			if (str.charAt(i) == '-') {
				sign = -1;
			}
			i++;
		}

		// 数字处理
		while (i < len && Character.isDigit(str.charAt(i))) {
			int tmp = str.charAt(i) - '0';
			// 判断越界情况
			if (sign == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7))) {
				return Integer.MAX_VALUE;
			}
			if (sign == -1
					&& (result > -(Integer.MIN_VALUE / 10) || (result == -(Integer.MIN_VALUE / 10) && tmp > 8))) {
				return Integer.MIN_VALUE;
			}
			result = result * 10 + tmp;
			i++;
		}

		return result * sign;
	}
}

/**
 * 有限状态机
 * 
 * @author pang
 *
 */
class Automata {
	// 状态
	private int state = 0;
	// 状态转换矩阵
	// 0: start : " "
	// 1: signed : -/+
	// 2: in_number : 0-9
	// 3: end : other
	private int[][] table = { { 0, 1, 2, 3 }, { 3, 3, 2, 3 }, { 3, 3, 2, 3 }, { 3, 3, 3, 3 } };
	// 结果
	long result = 0;
	// 符号
	int sign = 1;

	/**
	 * 根据传入字符判断下一个状态
	 * 
	 * @param c
	 *            字符
	 * @return 返回状态
	 */
	public int gets(char c) {
		if (c == ' ') {
			return 0;
		}
		if (c == '+' || c == '-') {
			return 1;
		}
		if (Character.isDigit(c)) {
			return 2;
		}
		return 3;
	}

	public void get(char c) {
		state = table[state][gets(c)];
		// 数字状态
		if (state == 2) {
			result = result * 10 + (c - '0');
			// 判断是否越界
			result = sign == 1 ? Math.min(result, Integer.MAX_VALUE) : Math.min(result, -(long) Integer.MIN_VALUE);
		}
		// 符号状态
		if (state == 1 && c == '-') {
			sign = -1;
		}
	}
}
