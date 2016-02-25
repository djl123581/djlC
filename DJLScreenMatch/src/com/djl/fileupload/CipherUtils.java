/*
 * Copyright (c) 2014, KJFrameForAndroid 张涛 (kymjs123@gmail.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.djl.fileupload;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 加密与解密的工具类<br>
 * 
 * <b>创建时间</b> 2014-8-14
 * 
 * @author kymjs(kymjs123@gmail.com)
 * @version 1.1
 */
public final class CipherUtils {

	/**
	 * MD5加密
	 */
	public static String md5(String string) {
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			// throw new KJException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			// throw new KJException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}
	/**
	 * SHA1加密
	 */
	public static String SHA1(String string) {
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("SHA1").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			// throw new KJException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			// throw new KJException("Huh, UTF-8 should be supported?", e);
		}
		
		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}
//	/**
//	 * Takes the raw bytes from the digest and formats them correct.
//	 *
//	 * @param bytes
//	 *            the raw bytes from the digest.
//	 * @return the formatted bytes.
//	 */
//	private static String getFormattedText(byte[] bytes) {
//		int len = bytes.length;
//		StringBuilder buf = new StringBuilder(len * 2);
//		// 把密文转换成十六进制的字符串形式
//		for (int j = 0; j < len; j++) { 			buf.append(HEX_DIGITS[(bytes[j] &gt;&gt; 4) &amp; 0x0f]);
//			buf.append(HEX_DIGITS[bytes[j] &amp; 0x0f]);
//		}
//		return buf.toString();
//	}
	/**
	 * 返回可逆算法DES的密钥
	 * 
	 * @param key
	 *            前8字节将被用来生成密钥。
	 * @return 生成的密钥
	 * @throws Exception
	 */
	public static Key getDESKey(byte[] key) throws Exception {
		DESKeySpec des = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		return keyFactory.generateSecret(des);
	}

	

}
