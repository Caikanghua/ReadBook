package com.readbook.utils;
/**
 * ��֤ѧ�����
 * @author caikanghua
 *
 */
public class StuVerifyUtils {
	
	public static int verfiyStuNum(String stuNum,String stuName){
		// ��δʵ��
		return 100;
	}
	public static String createRandomVcode(){
        //��֤��
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
