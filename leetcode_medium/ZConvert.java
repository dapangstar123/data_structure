package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R 
 * E T O E S I I G 
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows); 
 * 
 * 示例 1: 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN" 
 * 
 * 示例 2: 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 
 * 
 * 解释:
 * 
 * L     D     R 
 * E   O E   I I 
 * E C   I H   N 
 * T     S     G  
 * 
 * 
 * @author pang
 *
 */
public class ZConvert {
	public static void main(String[] args) {
		System.out.println(zConvert("LEETCODEISHIRING", 3));
		System.out.println(zConvert("LEETCODEISHIRING", 4));
	}
	// 可以循环遍历字符串，每个字符添加到合适的行，
	// 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
	public static String zConvert(String s, int numRows){
		if(numRows == 1 || numRows >= s.length()){
			return s;
		}
		// 每行保存成一个StringBuilder 然后放到ArrayList中
		List<StringBuilder> rows = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		// 当前行
		int curRow = 0;
		// 转换方向的标记
		boolean flag = false;
		// 循环每一个字符, 将字符添加到各自属于的行
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			// 如果树第一行 或者最后一行 转换标记
			if(curRow == 0 || curRow == numRows - 1){
				flag = !flag;
			}
			curRow += flag ? 1 : -1;
		}
		// 拼接各行
		StringBuilder result = new StringBuilder();
		for (StringBuilder row : rows) {
			result.append(row);
		}
		return result.toString();
	}
}
