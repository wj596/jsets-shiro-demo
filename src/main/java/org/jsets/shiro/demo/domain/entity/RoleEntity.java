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
import org.springframework.data.annotation.Id;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色实体
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@TableName("t_role")
public class RoleEntity implements Serializable{
	
	private static final long serialVersionUID = -2914079496867008988L;
	
	@Id
	private String code;// 名称
    private String name;// 描述
    private Integer status;//状态    1:正常、9：删除
    @TableField(exist = false)
    private String resourceNames;// 角色拥有的资源
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getResourceNames() {
		return resourceNames;
	}
	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}
}