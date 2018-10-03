package com.readbook.utils;

import java.util.List;

import com.readbook.pojo.RbUsercomment;

public class CheckUtils {
	 public static boolean checkMobile(String mobile) {  
         if(mobile.equals(null)){  
             return false; 
             /*^匹配开始地方$匹配结束地方，[3|4|5|7|8]选择其中一个{4,8},\d从[0-9]选择 
             {4,8}匹配次数4~8    ，java中/表示转义，所以在正则表达式中//匹配/,/匹配""*/  
         //验证手机号码格式是否正确  
         }else if(!mobile.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$")){  
             return false;
         }else{  
             return true;
         }  
     }  
}
