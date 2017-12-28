package org.jsets.shiro.demo.domain;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse extends HashMap<String, Object> {

	private static final long serialVersionUID = 6272655632566784880L;

	public static final int RESPOND_SUCCEED = 1;
	public static final int RESPOND_FAILURE = 0;

	public static BaseResponse build() {
		return new BaseResponse();
	}
	
	public static BaseResponse ok() {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put("respond", RESPOND_SUCCEED);
		return baseReturn;
	}
	
	public static BaseResponse ok(String message) {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put("respond", RESPOND_SUCCEED);
		baseReturn.put("message", message);
		return baseReturn;
	}
	
	public static BaseResponse fail() {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put("respond", RESPOND_FAILURE);
		return baseReturn;
	}
	
	public static BaseResponse fail(String message) {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put("respond", RESPOND_FAILURE);
		baseReturn.put("message", message);
		return baseReturn;
	}
	
	public BaseResponse respond(int respond) {
		this.put("respond", respond);
		return this;
	}
	
	public BaseResponse message(String message) {
		this.put("message", message);
		return this;
	}
	
	public BaseResponse add(String key,Object value) {
		this.put(key,value);
		return this;
	}
	
	public BaseResponse addAll(Map<String, ?> map) {
		this.putAll(map);
		return this;
	}

}