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
package org.jsets.shiro.demo.domain.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.jsets.shiro.demo.domain.BaseEntity;
import org.jsets.shiro.model.Account;
/**
 * 用户实体
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@Entity
@Table(name="t_user")
public class UserEntity extends BaseEntity implements Account{

	private static final long serialVersionUID = -7970046217356997350L;
	
	// 状态-删除
	public final static Short USER_STATUS_OK = 1;
	// 状态-锁定
	public final static Short USER_STATUS_LOCKED = 2;
	// 状态-删除
	public final static Short USER_STATUS_DELETED = 9;
	
	private String account; // 账号
	private String password; // 密码
    private String userName; // 用户姓名
    private Short sex;// 性别
	private String phone;// 电话
	private String email;// 邮箱
    private Date createTime;// 创建时间
    private String createUser;// 创建人
    private Short status;//状态    1:正常、9：删除
    @Transient
    private String roleCodes;//拥有的角色
    
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getRoleCodes() {
		return roleCodes;
	}
	public void setRoleCodes(String roleCodes) {
		this.roleCodes = roleCodes;
	}

}