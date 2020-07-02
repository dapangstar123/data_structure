package leetcode_medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 
 * 示例 1： 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 * 
 * 示例 2： 输入: "cbbd" 输出: "bb"
 * 
 * 
 * @author pang
 *
 */
public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("ggasdsagf"));
		System.out.println(longestPalindrome("abbd"));

	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			// 奇数长度序列
			int len1 = expandCenter(s, i, i);
			// 偶数长度序列
			int len2 = expandCenter(s, i, i + 1);
			int len = len1 > len2 ? len1 : len2;
			// 判断是否是最长
			if (len > end - start) {
				// 起始坐标
				start = i - (len - 1) / 2;
				// 终止坐标
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * 从中心向外扩展来判断回文序列
	 * 
	 * @param s
	 *            总序列
	 * @param left
	 *            向左偏移的下标
	 * @param right
	 *            向右偏移的下标
	 * @return 返回 回文序列的长度
	 */
	public static int expandCenter(String s, int left, int right) {
		int l = left;
		int r = right;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}

}
