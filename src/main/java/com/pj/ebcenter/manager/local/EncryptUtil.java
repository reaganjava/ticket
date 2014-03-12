package com.pj.ebcenter.manager.local;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * <p>Description: 支持base64,MD5,DES加解密</p>
 * @date 2013-9-3
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class EncryptUtil {

	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26,
			27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1,
			-1, -1, -1 };

	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
			'2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };

	/**
	   * MD5值计算<p>
	   * MD5的算法在RFC1321 中定义:
	   * 在RFC 1321中，给出了Test suite用来检验你的实现是否正确：
	   * MD5 ("") = d41d8cd98f00b204e9800998ecf8427e
	   * MD5 ("a") = 0cc175b9c0f1b6a831c399e269772661
	   * MD5 ("abc") = 900150983cd24fb0d6963f7d28e17f72
	   * MD5 ("message digest") = f96b697d7cb7938d525a2f31aaf161d0
	   * MD5 ("abcdefghijklmnopqrstuvwxyz") = c3fcd3d76192e4007dfb496cca67e13b
	   *
	   * @param res 源字符串
	   * @return md5值
	   */
	public final static byte[] MD5(String str) {
		try {
			byte[] res = str.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5".toUpperCase());
			mdTemp.update(res);
			byte[] hash = mdTemp.digest();
			return hash;
		} catch (Exception e) {
			return null;
		}
	}

	// 加密后解密
	public static String JM(byte[] inStr) {
		String newStr = new String(inStr);
		char[] a = newStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String BASE64Encrypt(byte[] key) {
		String edata = null;
		try {
			edata = (new BASE64Encoder()).encodeBuffer(key).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return edata;
	}

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] BASE64Decrypt(String data) {
		if (data == null)
			return null;
		byte[] edata = null;
		try {
			edata = (new BASE64Decoder()).decodeBuffer(data);
			return edata;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param key 24位密钥
	 * @param str 源字符串
	 * @return
	 * @throws EncryptException 
	 */
	public static byte[] DES3Encrypt(String key, String str) {

		byte[] bt;
		try {
			byte[] newkey = key.getBytes();

			SecureRandom sr = new SecureRandom();

			DESedeKeySpec dks = new DESedeKeySpec(newkey);

			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");

			SecretKey securekey = keyFactory.generateSecret(dks);

			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

			bt = cipher.doFinal(str.getBytes("utf-8"));

			return bt;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalAccessError();
		}

	}

	/**
	 * 解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String DES3Decrypt(byte[] edata, String key) {
		String data = "";
		try {
			if (edata != null) {
				byte[] newkey = key.getBytes();
				DESedeKeySpec dks = new DESedeKeySpec(newkey);
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
				SecretKey securekey = keyFactory.generateSecret(dks);
				Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
				cipher.init(Cipher.DECRYPT_MODE, securekey, new SecureRandom());
				String newData = new String(edata);
				// if (!newData.endsWith("=")){
				// data = URLDecoder.decode(newData,"utf-8");
				// }
				byte[] bb = cipher.doFinal(edata);
				data = new String(bb, "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static String Base64encodeInLine(byte[] data) {
		StringBuffer sb = new StringBuffer();
		int len = data.length;
		int i = 0;
		int b1, b2, b3;
		while (i < len) {
			b1 = data[i++] & 0xff;
			if (i == len) {
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
				sb.append("==");
				break;
			}
			b2 = data[i++] & 0xff;
			if (i == len) {
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
				sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
				sb.append("=");
				break;
			}
			b3 = data[i++] & 0xff;
			sb.append(base64EncodeChars[b1 >>> 2]);
			sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
			sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
			sb.append(base64EncodeChars[b3 & 0x3f]);
		}
		return sb.toString();
	}

	public static byte[] Base64DecodeInLine(String str) {

		StringBuffer sb = new StringBuffer();
		try {

			byte[] data = str.getBytes("US-ASCII");
			int len = data.length;
			int i = 0;
			int b1, b2, b3, b4;
			while (i < len) {

				do {
					b1 = base64DecodeChars[data[i++]];
				} while (i < len && b1 == -1);
				if (b1 == -1)
					break;

				do {
					b2 = base64DecodeChars[data[i++]];
				} while (i < len && b2 == -1);
				if (b2 == -1)
					break;
				sb.append((char) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

				do {
					b3 = data[i++];
					if (b3 == 61)
						return sb.toString().getBytes("iso8859-1");
					b3 = base64DecodeChars[b3];
				} while (i < len && b3 == -1);
				if (b3 == -1)
					break;
				sb.append((char) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

				do {
					b4 = data[i++];
					if (b4 == 61)
						return sb.toString().getBytes("iso8859-1");
					b4 = base64DecodeChars[b4];
				} while (i < len && b4 == -1);
				if (b4 == -1)
					break;
				sb.append((char) (((b3 & 0x03) << 6) | b4));
			}
			return sb.toString().getBytes("iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 * 方法用途: 签名加密<br>
	 * 实现步骤: <br>
	 * @param signStr ：签名的字符串
	 * @return   
	 */
	public static String encryptSigned(String signed) {
		byte[] md5SignStr = MD5(signed);
		String b64SignStr = BASE64Encrypt(md5SignStr);
		return b64SignStr;
	}
}
