/*
 * Copyright 2017-2018 the original author(https://github.com/wj596)
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package org.jsets.shiro.demo.domain;

import java.util.HashMap;
/**
 * 响应封装
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
public class BaseResponse extends HashMap<String, Object> {

	private static final long serialVersionUID = 6272655632566784880L;

	// 成功响应
	public static final int RESPOND_SUCCEED = 1;
	// 失败响应
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
}