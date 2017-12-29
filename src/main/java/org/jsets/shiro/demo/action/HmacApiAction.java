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
package org.jsets.shiro.demo.action;

import org.jsets.shiro.demo.domain.BaseResponse;
import org.jsets.shiro.service.ShiroSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * HMAC数字摘要鉴权   测试API
 *
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@RestController
@RequestMapping("/hmac_api")
public class HmacApiAction {
	
	@Autowired
	private ShiroSecurityService shiroSecurityService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public BaseResponse add(@RequestParam(name="parameter1") String parameter1
							,@RequestParam(name="parameter2") String parameter2) {
		
		return BaseResponse.ok()
				.add("parameter1", parameter1)
				.add("parameter2", parameter2)
				.message("add成功");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public BaseResponse delete(@RequestParam(name="parameter1") String parameter1
							,@RequestParam(name="parameter2") String parameter2) {

		return BaseResponse.ok()
				.add("parameter1", parameter1)
				.add("parameter2", parameter2)
				.message("delete成功");
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public BaseResponse update(@RequestParam(name="parameter1") String parameter1
							,@RequestParam(name="parameter2") String parameter2) {

		return BaseResponse.ok()
				.add("parameter1", parameter1)
				.add("parameter2", parameter2)
				.message("update成功");
	}
}