package com.readbook.utils;
/**
 * ���ַ�������������
 * @author caikanghua
 *
 */
public class StringUtils {
	
	public static boolean isBlank(String cs){
		int strLen;
	    if (cs == null || (strLen = cs.length()) == 0) {
	        return true;
	    }
	    for (int i = 0; i < strLen; i++) {
	        if (Character.isWhitespace(cs.charAt(i)) == false) {
	            return false;
	        }
	    }
	    return true;
	}
}
