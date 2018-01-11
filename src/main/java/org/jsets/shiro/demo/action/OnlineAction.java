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

import java.util.List;
import org.apache.shiro.session.Session;
import org.jsets.shiro.config.ShiroProperties;
import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.demo.domain.vo.OnlineUserVo;
import org.jsets.shiro.util.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.common.collect.Lists;

/**
 * 在线用户管理
 *
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@Controller
@RequestMapping("/online")
public class OnlineAction {
	/**
     * 当前在线用户
     */
    @RequestMapping("/list")
    public String list(Model model) {
    	// 当前存活的Session数量
    	int onlineCount = ShiroUtils.getActiveSessionCount();
    	// 当前存活的Session列表
    	List<Session> activeSessions = ShiroUtils.getActiveSessions();
    	// 包装OnlineUserVo
    	List<OnlineUserVo> onlineUsers = Lists.newArrayList();
    	for(Session session:activeSessions){
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
    	model.addAttribute("onlineCount",onlineCount);
    	model.addAttribute("onlineUsers",onlineUsers);
        return "online/online_list";
    }
    
    /**
     * 强制SESSION下线
     */
    @RequestMapping("/do_force_fogout")
    public String doForceLogout(@RequestParam(name="sessionId") String sessionId) {
    	ShiroUtils.forceLogout(sessionId);
        return "redirect:/online/list";
    }
}