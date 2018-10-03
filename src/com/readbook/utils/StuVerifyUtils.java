package com.readbook.utils;
/**
 * 验证学生身份
 * @author caikanghua
 *
 */
public class StuVerifyUtils {
	
	public static int verfiyStuNum(String stuNum,String stuName){
		// 暂未实现
		return 100;
	}
	public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
