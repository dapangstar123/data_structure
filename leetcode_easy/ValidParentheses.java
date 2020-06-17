package leetcode_easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号： 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 
 * 示例 1: 输入: "()" 输出: true
 * 
 * 示例 2: 输入: "()[]{}" 输出: true
 * 
 * 示例 3: 输入: "(]" 输出: false
 * 
 * 示例 4: 输入: "([)]" 输出: false
 * 
 * 示例 5: 输入: "{[]}" 输出: true
 * 
 * @author pang
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(}"));
		System.out.println(isValid("({)}"));
		System.out.println(isValid("({()}{[[[]]]}()(({{}})))"));
	}

	// 利用栈的思想
	public static boolean isValid(String s) {
		// 定义栈
		Stack<String> stack = new Stack<String>();
		// 定义hashmap
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(")", "(");
		map.put("]", "[");
		map.put("}", "{");

		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			if (!map.containsKey(c)) {
				stack.push(c);
			} else {
				// 获取栈顶元素
				String top = stack.isEmpty() ? "#" : stack.pop();
				if (!top.equals(map.get(c))) {
					return false;
				}
			}
		}
		// 如果栈为空说明全部都已经匹配到了,返回true
		return stack.isEmpty();
	}
}
