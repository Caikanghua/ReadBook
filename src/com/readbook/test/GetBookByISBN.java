package com.readbook.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;
import org.junit.Test;

public class GetBookByISBN {
	@Test
	public void getBookByIsbn(String isbn){
		JSONObject request = GetBookByISBN.httpRequest("https://api.douban.com/v2/book/isbn/:"+isbn+"", "GET");
		System.out.println("总体情况:"+request);
		Object author = request.get("author");
		Object publisher = request.get("publisher");
		Object title = request.get("title");
		String authorStr = author.toString();
		String substring = authorStr.substring(2, authorStr.length()-2);
		System.out.println(substring);
		System.out.println(publisher.toString());
		System.out.println(title.toString());
	}
	 public static JSONObject httpRequest(String requestUrl, String requestMethod) {    
	        JSONObject jsonObject = null;    
	        StringBuffer buffer = new StringBuffer();  
	        InputStream inputStream=null;  
	        try {  
	            URL url = new URL(requestUrl);  
	            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();    
	            // 设置请求方式（GET/POST）    
	            httpUrlConn.setRequestMethod(requestMethod);    
	            if ("GET".equalsIgnoreCase(requestMethod))    
	                httpUrlConn.connect();    
	            //将返回的输入流转换成字符串    
	            inputStream = httpUrlConn.getInputStream();    
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
	    
	            String str = null;    
	            while ((str = bufferedReader.readLine()) != null) {    
	                buffer.append(str);    
	            }    
	            bufferedReader.close();    
	            inputStreamReader.close();    
	            // 释放资源    
	            inputStream.close();    
	            inputStream = null;    
	            httpUrlConn.disconnect();    
	            jsonObject = JSONObject.fromObject(buffer.toString());  
	        } catch (ConnectException ce) {    
	              ce.printStackTrace();  
	              System.out.println("Weixin server connection timed out");  
	        } catch (Exception e) {    
	               e.printStackTrace();  
	               System.out.println("http request error:{}");  
	        }finally{  
	            try {  
	                if(inputStream!=null){  
	                    inputStream.close();  
	                }  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }   
	        return jsonObject;    
	    }    
}
