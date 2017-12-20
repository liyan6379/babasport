
package com.itcast.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {


	public static String filterEmoji(String source) {
		if (isEmpty(source)) {
			return source;
		}
		StringBuilder buf = null;
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isEmojiCharacter(codePoint)) {
				if (buf == null) {
					buf = new StringBuilder(source.length());
				}
				buf.append(codePoint);
			}
		}
		if (buf == null) {
			return source;
		} else {
			if (buf.length() == len) {
				buf = null;
				return source;
			} else {
				return buf.toString();
			}
		}
	}

	private static boolean isEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) ||
				(codePoint == 0x9) ||
				(codePoint == 0xA) ||
				(codePoint == 0xD) ||
				((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
				((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
				((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
	


	/**
	 * Check if a string is empty
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * Get the file's extension name, such as doc, png, jpeg
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtention(String filename) {
		String ext = null;
		int index = filename.lastIndexOf(".");
		if (index > 0) {
			ext = filename.substring(index + 1);
		}
		return ext;
	}

	/**
	 * Encrypt string s with MD5.
	 * 
	 * @param s
	 * @return
	 */
	public static String encodeMD5(String s) {
		if (isEmpty(s)) {
			return null;
		}
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			// ignore ex
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		md.update(s.getBytes());
		byte[] datas = md.digest();
		int len = datas.length;
		char str[] = new char[len * 2];
		int k = 0;
		for (int i = 0; i < len; i++) {
			byte byte0 = datas[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
	
	private static final String pattern="[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\u2600-\\u27ff]";  
	
	/**
	 * @author Rylan 2016年3月6日 下午2:43:58
	 * @Method: isEmojiString 
	 * @Description: 判断字符串中是否含有 Emoji表情字符
	 * @param str
	 * @return 
	 * @throws
	 */
	public static boolean isEmojiString(String str) {
		if(StringUtils.isEmpty(str)){
			return false;
		}
		Pattern emoji=Pattern.compile(pattern);  	
		Matcher  emojiMatcher=emoji.matcher(str);  		
		return emojiMatcher.find();
	}
	/**
	 * @author Rylan 2016年3月6日 下午2:56:43
	 * @Method: filEmojiString 
	 * @Description: 过滤Emoji表情
	 * @param str
	 * @return 
	 * @throws
	 */
	public static String filEmojiString(String str) {
		if(StringUtils.isEmpty(str)){
			return str;
		}
		Pattern emoji=Pattern.compile(pattern);  	
		Matcher  emojiMatcher=emoji.matcher(str);  		
		str=emojiMatcher.replaceAll("");
		return str;
	}

}
