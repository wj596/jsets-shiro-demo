package org.jsets.shiro.demo.action;

import org.jsets.shiro.demo.domain.BaseResponse;
import org.jsets.shiro.service.ShiroSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApiHmac")
public class RestApiHmacAction {
	
	@Autowired
	private ShiroSecurityService shiroSecurityService;
	
	@RequestMapping(value="/apiPost",method=RequestMethod.POST)
	public BaseResponse apiPost(@RequestParam(name="parameter1") String parameter1
			,@RequestParam(name="parameter2") String parameter2) {
		
		System.out.println("securityProvider："+shiroSecurityService.getUser());

		return BaseResponse.ok()
				.add("parameter1", parameter1)
				.add("parameter2", parameter2)
				.message("测试成功");
	}
	
	@RequestMapping(value="/apiGet",method=RequestMethod.GET)
	public BaseResponse apiPost(@RequestParam(name="parameter1") String parameter1
			,@RequestParam(name="parameter2") String parameter2
			,@RequestParam(name="hmac_app_id") String hmac_app_id
			,@RequestParam(name="hmac_timestamp") long hmac_timestamp
			,@RequestParam(name="hmac_digest") String hmac_digest) {

		return BaseResponse.ok()
				.add("parameter1", parameter1)
				.add("parameter2", parameter2)
				.message("测试成功");
	}
}