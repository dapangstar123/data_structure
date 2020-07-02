package leetcode_easy;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 
 * 1. 1; 2. 11; 3. 21; 4. 1211; 5. 111221
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 
 * 
 * 示例 1: 输入: 1 输出: "1" 解释：这是一个基本样例。
 * 
 * 示例 2: 输入: 4 输出: "1211" 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作
 * "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * 
 * 
 * @author pang
 *
 */
public class LookAndSay {
	public static void main(String[] args) {
		
		System.out.println(lookAndSay(1));
		System.out.println(lookAndSay(2));
		System.out.println(lookAndSay(3));
		System.out.println(lookAndSay(4));
		System.out.println(lookAndSay(5));
		System.out.println(lookAndSay(6));
		System.out.println(lookAndSay(7));
		System.out.println(lookAndSay(8));
		System.out.println(lookAndSay(9));
		System.out.println(lookAndSay(10));
		System.out.println(lookAndSay(11));
		System.out.println(lookAndSay(12));
		System.out.println(lookAndSay(20));
		
		
	}
	public static String lookAndSay(int n) {
		// n = 1 时
		String string = "1";
		// 从2开始循环
		for (int i = 2; i <= n; i++) {
			
			StringBuilder sb = new StringBuilder();
			// 获取第一个字符
			char pre = string.charAt(0);
			// 字符记数
			int count = 1;
			// 从第二个字符开始循环处理
			for (int j = 1; j < string.length(); j++) {
				char c = string.charAt(j);
				if (c == pre) {
					count++;
				} else {
					sb.append(count).append(pre);
					// 重置pre 和 count
					pre = c;
					count = 1;
				}
			}
			sb.append(count).append(pre);
			string = sb.toString();
		}
		return string;
	}
}
