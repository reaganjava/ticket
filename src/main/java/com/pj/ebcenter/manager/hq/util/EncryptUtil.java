package com.pj.ebcenter.manager.hq.util;

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
 * @author あんど おか
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class EncryptUtil {

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
	@SuppressWarnings("restriction")
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
	@SuppressWarnings("restriction")
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
