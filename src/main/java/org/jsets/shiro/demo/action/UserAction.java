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
import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.base.Strings;

/**
 * 角色管理
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/list")
    public String list(Model model) {
    	model.addAttribute("users", userService.list());
        return "user/user_list";
    }
    
    @RequestMapping("/edit")
    public String edit(Model model,@RequestParam(name="account",required=false) String account) {
    	if(!Strings.isNullOrEmpty(account))
    		model.addAttribute("user", userService.getByAccount(account));
        return "user/user_add";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody BaseResponse save(@RequestBody UserEntity user) {
    	userService.save(user);
        return BaseResponse.ok().message("用户添加成功");
    }
    
    
    /**
     * 加锁、解锁
     */
    @RequestMapping(value = "/switch_lock", method = RequestMethod.POST)
    public @ResponseBody BaseResponse switchLock(@RequestParam(name="account") String account
    											,@RequestParam Integer lockStatus) {
    	userService.updateStatus(account, lockStatus);
        return BaseResponse.ok().message("用户操作成功");
    }
    
}
