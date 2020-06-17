package leetcode_easy;

/**
 * 最长公共前缀 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 
 * 示例 1: 输入: ["flower","flow","flight"] 输出: "fl"
 * 
 * 示例 2: 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 
 * 说明: 所有输入只包含小写字母 a-z 。
 * 
 * 
 * @author pang
 *
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };

		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		// 用第一个元素作为对照
		for (int i = 0; i < strs[0].length(); i++) {
			// 获取索引处元素
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
