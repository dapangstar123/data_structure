package com.md5;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * MD5加密算法
 * 
 * @author pang
 *
 */

public class MD5 {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";
		byte[] md5 = md5(str.getBytes());
		// 打印加密之后的byte数组
		System.out.println(Arrays.toString(md5));
		// 打印加密之后的16进制字符串 BigInteget()构造函数中1为符号位，表示正数
		System.out.println(new BigInteger(1, md5).toString(16));

	}

	// 定义标准的幻数 采用小端存储（高地址存高位，低地址存低位）
	private static final int A = 0x67452301;
	private static final int B = 0xEFCDAB89;
	private static final int C = 0x98BADCFE;
	private static final int D = 0x10325476;

	private static final int[] S = { 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 5, 9, 14, 20, 5, 9, 14,
			20, 5, 9, 14, 20, 5, 9, 14, 20, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 6, 10, 15, 21,
			6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21 };

	/**
	 * MD5加密主程序
	 * 
	 * @param b
	 *            待加密的byte数组
	 * @return
	 */
	public static byte[] md5(byte[] b) {
		// 对数据进行补位
		byte[] padding = padding(b);
		// 加密
		byte[] digest = digest(padding);
		return digest;
	}

	/**
	 * 加密过程程序
	 * 
	 * @param data
	 *            补位后的byte数组
	 * @return
	 */
	public static byte[] digest(byte[] data) {
		// 定义一个数组用来保存结果
		int[] result = { A, B, C, D };

		// 分组，每个组64个字节，也就是512位
		int groupCount = data.length / 64;
		// 获取常量表
		int[] T = getConstTable();
		// 每组循环处理
		for (int i = 0; i < groupCount; i++) {
			// 获取分组数据
			int[] x = getGroupData(data, i * 64);

			int a = result[0];
			int b = result[1];
			int c = result[2];
			int d = result[3];

			for (int j = 0; j < 64; j += 4) {
				if (j <= 15) {
					// 第一轮
					a = FF(a, b, c, d, x[j], S[j], T[j]);
					d = FF(d, a, b, c, x[j + 1], S[j + 1], T[j + 1]);
					c = FF(c, d, a, b, x[j + 2], S[j + 2], T[j + 2]);
					b = FF(b, c, d, a, x[j + 3], S[j + 3], T[j + 3]);

				} else if (j <= 31) {
					// 第二轮
					a = GG(a, b, c, d, x[(5 * j + 1) % 16], S[j], T[j]);
					d = GG(d, a, b, c, x[(5 * (j + 1) + 1) % 16], S[j + 1], T[j + 1]);
					c = GG(c, d, a, b, x[(5 * (j + 2) + 1) % 16], S[j + 2], T[j + 2]);
					b = GG(b, c, d, a, x[(5 * (j + 3) + 1) % 16], S[j + 3], T[j + 3]);
				} else if (j <= 47) {
					// 第三轮
					a = HH(a, b, c, d, x[(3 * j + 5) % 16], S[j], T[j]);
					d = HH(d, a, b, c, x[(3 * (j + 1) + 5) % 16], S[j + 1], T[j + 1]);
					c = HH(c, d, a, b, x[(3 * (j + 2) + 5) % 16], S[j + 2], T[j + 2]);
					b = HH(b, c, d, a, x[(3 * (j + 3) + 5) % 16], S[j + 3], T[j + 3]);
				} else {
					// 第四轮
					a = II(a, b, c, d, x[(7 * j) % 16], S[j], T[j]);
					d = II(d, a, b, c, x[(7 * (j + 1)) % 16], S[j + 1], T[j + 1]);
					c = II(c, d, a, b, x[(7 * (j + 2)) % 16], S[j + 2], T[j + 2]);
					b = II(b, c, d, a, x[(7 * (j + 3)) % 16], S[j + 3], T[j + 3]);

				}
			}
			result[0] += a;
			result[1] += b;
			result[2] += c;
			result[3] += d;
		}
		// 得到的result[] 是包含四个32位的结果，需要将其转换一下格式
		byte[] resultByte = new byte[16];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// 依次获取低八位的结果
				resultByte[i * 4 + j] = (byte) (result[i] & 0xFF);
				result[i] = result[i] >> 8;
			}
		}
		return resultByte;
	}

	/**
	 * 获取分组数据 64个字节为一组
	 * 
	 * @param data
	 *            要分组的总数据
	 * @param index
	 *            分组的索引
	 * @return int[] 返回一个长度为16 ，每个元素32位的int类型的数组
	 */
	public static int[] getGroupData(byte[] data, int index) {
		int[] groupData = new int[16];

		for (int i = 0; i < 16; i++) {
			groupData[i] = (data[4 * i + index] & 0xFF) | (data[4 * i + 1 + index] & 0xFF) << 8
					| (data[4 * i + 2 + index] & 0xFF) << 16 | (data[4 * i + 3 + index] & 0xFF) << 24;
		}

		return groupData;
	}

	/**
	 * 对数据进行补位
	 * 
	 * @param b2
	 * @return
	 */
	private static byte[] padding(byte[] b2) {
		int length = b2.length;
		long bitLength = length << 3;
		int rest = length % 64;
		int paddingLength = 0;
		if (rest < 56) {
			paddingLength = 64 - rest;
		} else {
			paddingLength = 128 - rest;
		}
		// 补位数据
		byte[] paddingData = new byte[length + paddingLength];
		for (int i = 0; i < length; i++) {
			paddingData[i] = b2[i];
		}
		// 先填补一个1
		paddingData[length] = (byte) (1 << 7);
		// 在1后面补上0
		for (int i = 1; i < paddingLength - 8; i++) {
			paddingData[length + i] = 0;
		}
		// 剩下的64位,也就是8个字节补上字符的长度
		for (int i = 0; i < 8; i++) {
			// 每次取低8位字节，依次向前补充
			paddingData[length + paddingLength - 8 + i] = (byte) (bitLength & 0xFF);
			bitLength = bitLength >>> 8;
		}
		return paddingData;
	}

	/**
	 * 获取常量表
	 * 
	 * @return T是一个常量表，T[i] = 4294967296 * abs(sin(i))的运算结果取整，其中i=1...64
	 */
	public static int[] getConstTable() {
		int[] T = new int[64];
		for (int i = 0; i < 64; i++) {
			T[i] = (int) ((long) (Math.abs(Math.sin(i + 1)) * 4294967296l));
		}
		return T;
	}

	// 定义四个辅助方法
	private static int F(int x, int y, int z) {
		return (x & y) | ((~x) & z);
	}

	private static int G(int x, int y, int z) {
		return (x & z) | (y & (~z));
	}

	private static int H(int x, int y, int z) {
		return x ^ y ^ z;
	}

	private static int I(int x, int y, int z) {
		return y ^ (x | (~z));
	}

	// 开始处理分组
	// 第一轮
	private static int FF(int a, int b, int c, int d, int x, int s, int t) {
		a += (F(b, c, d) & 0xFFFFFFFF) + x + t;
		a = ((a & 0xFFFFFFFF) << s) | ((a & 0xFFFFFFFF) >>> (32 - s)); // 循环位移
		a += b;
		return (a & 0xFFFFFFFF);
	}

	// 第二轮
	private static int GG(int a, int b, int c, int d, int x, int s, int t) {
		a += (G(b, c, d) & 0xFFFFFFFF) + x + t;
		a = ((a & 0xFFFFFFFF) << s) | ((a & 0xFFFFFFFF) >>> (32 - s));
		a += b;
		return (a & 0xFFFFFFFF);
	}

	// 第三轮
	private static int HH(int a, int b, int c, int d, int x, int s, int t) {
		a += (H(b, c, d) & 0xFFFFFFFF) + x + t;
		a = ((a & 0xFFFFFFFF) << s) | ((a & 0xFFFFFFFF) >>> (32 - s));
		a += b;
		return (a & 0xFFFFFFFF);
	}

	// 第四轮
	private static int II(int a, int b, int c, int d, int x, int s, int t) {
		a += (I(b, c, d) & 0xFFFFFFFF) + x + t;
		a = ((a & 0xFFFFFFFF) << s) | ((a & 0xFFFFFFFF) >>> (32 - s));
		a += b;
		return (a & 0xFFFFFFFF);
	}

}
