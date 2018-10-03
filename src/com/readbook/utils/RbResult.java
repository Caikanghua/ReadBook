package com.readbook.utils;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 返回结果
 * @author caikanghua
 *
 */
public class RbResult implements Serializable{
	  // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer statusCode;

    // 响应消息
    private String message;

    // 响应中的数据
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
     * 将json结果集转化为TaotaoResult对象
     * 
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
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
     * 没有object对象的转化
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
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
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
