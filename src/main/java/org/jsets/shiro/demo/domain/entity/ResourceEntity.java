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

import javax.persistence.Entity;
import javax.persistence.Table;
import org.jsets.shiro.demo.domain.BaseEntity;
/**
 * 资源实体
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@Entity
@Table(name="t_resource")
public class ResourceEntity extends BaseEntity{

	private static final long serialVersionUID = -8265881454439961651L;
	
	// 菜单
	public static final int RESOURCE_TYPE_MENU = 1;
	// 按钮
	public static final int RESOURCE_TYPE_BUTTON = 2;
	
	private String code;// 编码
    private String name;// 名称
    private String parentId;// 父编号
    private String url;// 路径
    private Short type; //类型 1:菜单 2:按钮
    private Short status;//状态    1:正常、9：删除
    
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}

}