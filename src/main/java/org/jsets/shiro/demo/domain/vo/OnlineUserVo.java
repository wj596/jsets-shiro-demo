package org.jsets.shiro.demo.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户值对象
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
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