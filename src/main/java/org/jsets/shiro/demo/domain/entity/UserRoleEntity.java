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

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户--角色对应  实体
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@TableName("t_user_role")
public class UserRoleEntity implements Serializable{

	private static final long serialVersionUID = 5923259786012610208L;
	
	private String id;// 主键
	private String userId;
	private String roleId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}