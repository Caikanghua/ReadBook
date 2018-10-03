package com.readbook.utils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * �������󹤾���
 * @author caikanghua
 *
 */
public class HttpRequestUtil {
	/**
	 * HttpClient ģ��POST����
	 * @param url
	 * @param params
	 * @return
	 */
	public static String postRequest(String url, Map<String, String> params) {
        //����HttpClient��ʵ��
        HttpClient httpClient = new HttpClient();

        //����POST������ʵ��
        PostMethod postMethod = new PostMethod(url);

        //��������ͷ��Ϣ
        postMethod.setRequestHeader("Connection", "close");

        //��Ӳ���
        for (Map.Entry<String, String> entry : params.entrySet()) {
            postMethod.addParameter(entry.getKey(), entry.getValue());
        }

        //ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����,�����������Դ����õ���Ĭ�ϵ����Դ�����������
        httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);

        //���մ�����
        String result = null;
        try {
            //ִ��Http Post����
            httpClient.executeMethod(postMethod);

            //���ش�����
            result = postMethod.getResponseBodyAsString();
        } catch (HttpException e) {
            // �����������쳣��������Э�鲻�Ի��߷��ص�����������
            System.out.println("���������URL!");
            e.printStackTrace();
        } catch (IOException e) {
            // ���������쳣
            System.out.println("���������쳣!");
            e.printStackTrace();
        } finally {
            //�ͷ�����
            postMethod.releaseConnection();

            //�ر�HttpClientʵ��
            if (httpClient != null) {
                ((SimpleHttpConnectionManager) httpClient.getHttpConnectionManager()).shutdown();
                httpClient = null;
            }
        }
        return result;
    }
	/**
	 * HttpClient ģ��GET����
	 * @param url
	 * @param params
	 * @return
	 */
    public static String getRequest(String url, Map<String, String> params) {
        //����HttpClientʵ��
        HttpClient client = new HttpClient();

        //ƴ�Ӳ���
        String paramStr = "";
        for (String key : params.keySet()) {
            paramStr = paramStr + "&" + key + "=" + params.get(key);
        }
        paramStr = paramStr.substring(1);

        //����GET������ʵ��
        GetMethod method = new GetMethod(url + "?" + paramStr);

        //���շ��ؽ��
        String result = null;
        try {
            //ִ��HTTP GET��������
            client.executeMethod(method);

            //���ش�����
            result = method.getResponseBodyAsString();
        } catch (HttpException e) {
            // �����������쳣��������Э�鲻�Ի��߷��ص�����������
            System.out.println("���������URL!");
            e.printStackTrace();
        } catch (IOException e) {
            // ���������쳣
            System.out.println("���������쳣!");
            e.printStackTrace();
        } finally {
            //�ͷ�����
            method.releaseConnection();

            //�ر�HttpClientʵ��
            if (client != null) {
                ((SimpleHttpConnectionManager) client.getHttpConnectionManager()).shutdown();
                client = null;
            }
        }
        return result;
    }
    /**
     * ��ȡ����ͷ��Ϣ
     * @param request
     * @return
     */
    public static String getHeadersInfo(HttpServletRequest request) {  
        Map<String, String> map = new HashMap<String, String>();  
        Enumeration headerNames = request.getHeaderNames();  
        while (headerNames.hasMoreElements()) {  
            String key = (String) headerNames.nextElement();  
            String value = request.getHeader(key);  
            map.put(key, value);  
        }  
          
        String result="";  
        for (String key : map.keySet()) {    
            //System.out.println("key= "+ key + " and value= " + map.get(key));    
         result = result + "key= "+ key + " and value= " + map.get(key)+"\n";  
           }    
        return result;  
      }  
}
