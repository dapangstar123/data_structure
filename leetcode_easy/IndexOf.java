package leetcode_easy;

/**
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * 
 * 
 * @author pang
 *
 */
public class IndexOf {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "ell";
		System.out.println(strStr(s1, s2));
	}

	public static int strStr(String haystack, String needle) {
		// 先获取两个字符串的长度
		int n1 = haystack.length();
		int n2 = needle.length();
		if (n2 == 0) {
			return 0;
		}
		// 母串的指针
		int i = 0;
		while (i < n1 - n2 + 1) {
			// 在haystack字符串中找到needle第一个字符出现的位置
			while (i < n1 - n2 + 1 && haystack.charAt(i) != needle.charAt(0)) {
				i++;
			}
			int curLen = 0; // 匹配到的长度
			int j = 0; // needle 的指针
			// 匹配
			while (i < n1 && j < n2 && haystack.charAt(i) == needle.charAt(j)) {
				++i;
				++j;
				++curLen;
			}
			if (curLen == n2) {
				return i - n2;
			}
			// 回溯母指针
			i = i - curLen + 1;
		}
		return -1;
	}
}
