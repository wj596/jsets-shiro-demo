package org.jsets.shiro.demo.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.session.Session;
import org.jsets.shiro.config.ShiroProperties;
import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.demo.domain.vo.OnlineUserVo;
import org.jsets.shiro.service.ShiroSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.common.collect.Lists;

/**
 * 主页、各种跳转ACTION
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
 */ 
@Controller
public class IndexAction {
	
	@Autowired
	private ShiroSecurityService shiroSecurityService;
	
    /**
     * 系统主页
     * 登陆成功后，跳转至此
     */
    @RequestMapping("/")
    public String index() {// 主页
        return "index";
    }
    /**
     * 登陆页面
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 访问无权限的地址被拦截后，跳转至此
     */
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * 开启只保留一个用户
     * 当账号在别处登陆后，当前用户被提出后，跳转至此
     */
    @RequestMapping("/kickout")
    public String kickout(HttpServletRequest request) {
    	this.shiroSecurityService.setAuthMessage(request, "此账号已经在别处登陆,您可以更换账号或者联系统管理员"); 
        return "login";
    }
    /**
     * 当前用户被管理员强制退出后，跳转至此
     */
    @RequestMapping("/force")
    public String forceLogout(HttpServletRequest request) {
    	this.shiroSecurityService.setAuthMessage(request, "您已被管理员强制退出,请联系统管理员");
        return "login";
    }
    /**
     * 当前用户基本信息
     */
    @RequestMapping("/abuotMe")
    public String abuotMe(Model model) {
    	// 当前登陆用户
    	model.addAttribute("user", this.shiroSecurityService.getUser());
    	// 当前登陆用户的角色列表
    	//model.addAttribute("roles", this.securityProvider.getCurrentUserRoles().toString());
    	// 当前登陆用户的权限列表
    	//model.addAttribute("permissions", this.securityProvider.getCurrentUserPerms().toString());
        return "abuot_me";
    }
    /**
     * 当前在线用户
     */
    @RequestMapping("/onlines")
    public String onlines(Model model) {
    	//当前在线用户数
    	model.addAttribute("activeCount",this.shiroSecurityService.getActiveSessionCount());
    	List<OnlineUserVo> onlineUsers = Lists.newArrayList();
    	List<Session> sessions = this.shiroSecurityService.getActiveSessions();
    	for(Session session:sessions){
    		OnlineUserVo onlineUser = new OnlineUserVo();
    		onlineUser.setSessionId((String)session.getId());
    		onlineUser.setStartTime(session.getStartTimestamp());
    		onlineUser.setLastAccess(session.getLastAccessTime());
    		onlineUser.setHost(session.getHost());
    		onlineUser.setTimeout(session.getTimeout());
    		// 从SESSION中获取里面的用户属性
    		UserEntity user = (UserEntity) session.getAttribute(ShiroProperties.ATTRIBUTE_SESSION_CURRENT_USER);
    		if(null!=user){
    			onlineUser.setUserName(user.getUserName());
    		}else{
    			onlineUser.setUserName("无效的，等待被清理");
    		}
    		if(null!=session.getAttribute(ShiroProperties.ATTRIBUTE_SESSION_FORCE_LOGOUT))
    			onlineUser.setForceLogout(true);
    		onlineUsers.add(onlineUser);
    	}
    	model.addAttribute("onlineUsers",onlineUsers);
        return "onlines";
    }
    
    /**
     * 根据SESSION ID 使其强制退出 
     */
    @RequestMapping("/doForceLogout")
    public String doForceLogout(@RequestParam(name="sessionId") String sessionId) {
    	System.out.println("doForceLogout sessionId:"+sessionId);
    	this.shiroSecurityService.forceLogout(sessionId);
        return "redirect:/onlines";
    }
}