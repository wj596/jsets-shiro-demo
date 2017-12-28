package org.jsets.shiro.demo.action;

import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import org.jsets.shiro.config.ShiroProperties;
import org.jsets.shiro.demo.domain.BaseResponse;
import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.util.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/rest")
public class RestDemoAction {
	
	@Autowired
	private ShiroProperties shiroProperties;
	
    /**
     * hmac签名鉴权
     */
    @RequestMapping("/hmac")
    public String hamc(Model model) {
    	model.addAttribute("hmacAlg",shiroProperties.getHmacAlg());
    	model.addAttribute("hmacSecretKey",shiroProperties.getHmacSecretKey());
    	return "/rest/rest-hmac";
    }
    

    @RequestMapping("/hmac_digest")
    public @ResponseBody BaseResponse save(@RequestParam(name="base_string") String base_string) {
    	
    	String hmac_digest = CryptoUtil.hmacDigest(base_string
    							,shiroProperties.getHmacSecretKey(),shiroProperties.getHmacAlg());

        return BaseResponse.ok()
        		.add("hmac_digest", hmac_digest)
        		.message("摘要成功");
    }
    
    @RequestMapping("/test_post")
    public @ResponseBody BaseResponse test_post(@RequestParam(name="parameter1") String parameter1
			,@RequestParam(name="parameter2") String parameter2
			,@RequestParam(name="hmac_app_id") String hmac_app_id
			,@RequestParam(name="hmac_timestamp") long hmac_timestamp
			,@RequestParam(name="hmac_digest") String hmac_digest
			,HttpServletRequest request) {
    	String restPostUrl = request.getRequestURL().toString().replace("rest/test_post", "restApiHmac/apiPost");
		RestTemplate rest = new RestTemplate();
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
		form.add("parameter1", parameter1); 
		form.add("parameter2", parameter2); 
	    form.add("hmac_app_id", hmac_app_id); 
	    form.add("hmac_timestamp", hmac_timestamp); 
	    form.add("hmac_digest", hmac_digest); 
	    try{
	    	String result = rest.postForObject(restPostUrl, form, String.class);
	        return BaseResponse.ok().message(result);
	    }catch(HttpClientErrorException e){
	        return BaseResponse.fail().message(e.getResponseBodyAsString());
	    }
    }
	
    
    /**
     * jwt鉴权
     */
    @RequestMapping("/jwt")
    public String jwt() {
    	return "/rest/rest-jwt";
    }
	
}