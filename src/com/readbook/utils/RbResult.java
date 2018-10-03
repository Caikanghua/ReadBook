package com.readbook.utils;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * ���ؽ��
 * @author caikanghua
 *
 */
public class RbResult implements Serializable{
	  // ����jackson����
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // ��Ӧҵ��״̬
    private Integer statusCode;

    // ��Ӧ��Ϣ
    private String message;

    // ��Ӧ�е�����
    private Object result;

    public static RbResult build(Integer statusCode, String message, Object result) {
        return new RbResult(statusCode, message, result);
    }

    public static RbResult ok(Object result) {
        return new RbResult(result);
    }

    public static RbResult ok() {
        return new RbResult(null);
    }

    public RbResult() {

    }

    public static RbResult build(Integer statusCode, String message) {
        return new RbResult(statusCode, message, null);
    }

    public RbResult(Integer statusCode, String message, Object result) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

    public RbResult(Object result) {
        this.statusCode = 102;
        this.message = "success";
        this.result = result;
    }

    public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * ��json�����ת��ΪTaotaoResult����
     * 
     * @param jsonData json����
     * @param clazz TaotaoResult�е�object����
     * @return
     */
    public static RbResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, RbResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode result = jsonNode.get("result");
            Object obj = null;
            if (clazz != null) {
                if (result.isObject()) {
                    obj = MAPPER.readValue(result.traverse(), clazz);
                } else if (result.isTextual()) {
                    obj = MAPPER.readValue(result.asText(), clazz);
                }
            }
            return build(jsonNode.get("statusCode").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * û��object�����ת��
     * 
     * @param json
     * @return
     */
    public static RbResult format(String json) {
        try {
            return MAPPER.readValue(json, RbResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object�Ǽ���ת��
     * 
     * @param jsonData json����
     * @param clazz �����е�����
     * @return
     */
    public static RbResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode result = jsonNode.get("result");
//            JsonNode jsonNode2 = jsonNode.get("result");
           
            Object obj = null;
            if (result.isArray() && result.size() > 0) {
                obj = MAPPER.readValue(result.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("statusCode").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
