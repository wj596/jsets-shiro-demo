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

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/list")
    public String index(Model model) {
    	model.addAttribute("users", userService.list());
        return "user/user-list";
    }
    
    @RequestMapping("/add")
    public String add(Model model,@RequestParam(name="account",required=false) String account) {
    	if(!Strings.isNullOrEmpty(account))
    		model.addAttribute("user", userService.getByAccount(account));
        return "user/user-add";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody BaseResponse save(@RequestBody UserEntity user) {
    	System.out.println(JSON.toJSONString(user));
    	userService.save(user);
        return BaseResponse.ok().message("用户添加成功");
    }
    
    @RequestMapping(value = "/switchLock", method = RequestMethod.POST)
    public @ResponseBody BaseResponse switchLock(@RequestParam(name="account") String account,
    		@RequestParam Short lockStatus) {
    	userService.updateStatus(account, lockStatus);
        return BaseResponse.ok().message("用户操作成功");
    }
    
}
