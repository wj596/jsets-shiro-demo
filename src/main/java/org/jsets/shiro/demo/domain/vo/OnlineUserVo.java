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
package org.jsets.shiro.demo.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户值对象
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
public class OnlineUserVo implements Serializable {

	private static final long serialVersionUID = 1L;
	// Session id
	private String sessionId;
	// 访问者主机
	private String host;
	// Session创建时间
	private Date startTime;
	// Session最后交互时间
	private Date lastAccess;
	// Session超时时间
	private long timeout;
	// 登陆用户姓名
	private String userName;
	// Session是否被强制退出
	private boolean forceLogout = Boolean.FALSE;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isForceLogout() {
		return forceLogout;
	}
	public void setForceLogout(boolean forceLogout) {
		this.forceLogout = forceLogout;
	}
}