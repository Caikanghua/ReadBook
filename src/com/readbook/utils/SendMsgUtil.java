package com.readbook.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.readbook.service.RbBookService;
import com.readbook.service.UserService;
import com.readbook.service.impl.UserServiceImpl;

import net.sf.json.JSONObject;
/**
 * 发送短信验证
 * @author caikanghua
 *
 */
public class SendMsgUtil {
    //2.发送短信
    public static void sendMsg(String phone, String message){
    	MessageApi.sendMessage(message, phone);
    }
    public static String sendMsg(String phone){
        String randomVcode = createRandomVcode();
        String str = "您正在注册，您的验证码为:"+randomVcode+"【深大书屋】";
        MessageApi.sendMessage(str, phone);
        return randomVcode;
    }
	    /**
	     * 随机生成六位随机数
	     * @return
	     */
	    public static String createRandomVcode(){
	        //验证码
	        String vcode = "";
	        for (int i = 0; i < 6; i++) {
	            vcode = vcode + (int)(Math.random() * 9);
	        }
	        return vcode;
	    }
	  //将map型转为请求参数型
	    public static String urlencode(Map<String,Object>data) {
	        StringBuilder sb = new StringBuilder();
	        for (Map.Entry i : data.entrySet()) {
	            try {
	                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }

		public static void sendRvSuccess(RbBookService rbBookService, String location,String bookId, Date takenDate,
				String phone,String slotTime) {
			//获取书名
			String bookName=rbBookService.getBookNameById(bookId);
			System.out.println(bookName+"书,预约成功测试");
			//解析时间
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String str = format.format(takenDate);
			String message="尊敬的用户你好，你已成功预约"+bookName+"书，请于预约时间"+str+"日  "+slotTime+"前往学活"+location+"窗口领取【深大书屋】";
			MessageApi.sendMessage(message, phone);
/*			System.out.println("takenDate:"+str);
			System.out.println("location"+location);
//			String month = str.substring(5, 7);
//			String day =str.substring(8,10);
//			String hour=str.substring(11, 13);
//			String minute=str.substring(14, 16);
	*/
		}

		public static void sendRvFail(String reason, String phone) throws Exception{
			MessageApi.sendMessage(reason, phone);
//			reason="预约失败测试:"+reason;
//			String result =null;
//	        String url ="http://v.juhe.cn/sms/send";//请求接口地址
//	        Map params = new HashMap();//请求参数
//	            params.put("mobile",phone);//接收短信的手机号码
//	            params.put("tpl_id",66239);//短信模板ID，请参考个人中心短信模板设置
//	            params.put("tpl_value","#code#="+reason);//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
//	            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
//	            params.put("dtype","");//返回数据的格式,xml或json，默认json
//	        try {
//	            result =net(url, params, "GET");
//	            JSONObject object = JSONObject.fromObject(result);
//	            if(object.getInt("error_code")==0){
//	                System.out.println(object.get("result"));
//	            }else{
//	                System.out.println(object.get("error_code")+":"+object.get("reason"));
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
		}
		public static String sendResetPasswordMsg(String phone) {
			String randomVcode = createRandomVcode();
	        String str = "您正在重启密码，您的重置密码验证码为:"+randomVcode+"【深大书屋】";
	        MessageApi.sendMessage(str, phone);
	        return randomVcode;
		}
}
