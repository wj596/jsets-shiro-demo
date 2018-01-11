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

import javax.servlet.http.HttpServletRequest;
import org.jsets.shiro.util.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 主页、各种跳转
 *
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@Controller
public class IndexAction {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    /**
     * 
     * 默认页面
     * 
     */
    @RequestMapping("/")
    public String def() {
    	 return "index";
    }
	
	
    /**
     * 
     * 登陆页面
     * 
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    /**
     * 
     * 系统主页
     * 登陆成功后，跳转至此
     * 
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    
    /**
     * 访问无权限的地址被拦截后，跳转至此
     */
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * 
     * 当前账号在别处登陆，当前用户被提出后，跳转至此。
     * 
     * 这里给出一句提示后直接转到login页面，如果真实场景可以做个更友好的界面
     * 
     */
    @RequestMapping("/kickout")
    public String kickout(HttpServletRequest request) {
    	ShiroUtils.setAuthMessage(request, "此账号已经在别处登陆,您可以更换账号或者联系统管理员"); 
        return "login";
    }
    
    /**
     * 
     * 当前账号被系统管理员强制下线后，跳转至此。
     * 
     * 这里给出一句提示后直接转到login页面，如果真实场景可以做个更友好的界面
     * 
     */
    @RequestMapping("/force_logout")
    public String forceLogout(HttpServletRequest request) {
    	ShiroUtils.setAuthMessage(request, "您已被管理员强制退出,请联系统管理员");
        return "login";
    }
    
    /**
     * 
     * 当前用户基本信息。
     * 
     * shiroSecurityService.getUser()取出当前用户
     * 
     */
    @RequestMapping("/abuot_me")
    public String abuotMe(Model model) {
    	///演示：强制转换为具体类型
    	///UserEntity user = (UserEntity) ShiroUtils.getUser();
    	///LOGGER.debug(JSON.toJSONString(user));
    	// 当前登陆用户
    	model.addAttribute("user", ShiroUtils.getUser());
        return "abuot_me";
    }

}