package com.readbook.utils;

import java.util.List;

import com.readbook.pojo.RbUsercomment;

public class CheckUtils {
	 public static boolean checkMobile(String mobile) {  
         if(mobile.equals(null)){  
             return false; 
             /*^ƥ�俪ʼ�ط�$ƥ������ط���[3|4|5|7|8]ѡ������һ��{4,8},\d��[0-9]ѡ�� 
             {4,8}ƥ�����4~8    ��java��/��ʾת�壬������������ʽ��//ƥ��/,/ƥ��""*/  
         //��֤�ֻ������ʽ�Ƿ���ȷ  
         }else if(!mobile.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$")){  
             return false;
         }else{  
             return true;
         }  
     }  
}
