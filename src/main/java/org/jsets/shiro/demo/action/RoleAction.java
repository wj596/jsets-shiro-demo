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
import org.jsets.shiro.demo.domain.BaseResponse;
import org.jsets.shiro.demo.domain.entity.ResourceEntity;
import org.jsets.shiro.demo.service.ResourceService;
import org.jsets.shiro.demo.service.RoleResourceService;
import org.jsets.shiro.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.collect.Lists;

/**
 * 角色管理
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@Controller
@RequestMapping("/role")
public class RoleAction {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RoleResourceService roleResourceService;
	
    @RequestMapping("/list")
    public String list(Model model) {
    	model.addAttribute("roles", roleService.list());
        return "role/role_list";
    }
    
    /**
     * 
     * 为角色分配资源
     *
     */
    @RequestMapping("/allot_resource")
    public String allotResource(@RequestParam(name="roleId") String roleId,Model model) {
    	model.addAttribute("roleId", roleId);
    	model.addAttribute("resources", resourceService.list());
    	List<String> selecteds = Lists.newArrayList();
    	for(ResourceEntity resource:roleResourceService.listResourceByRole(roleId)){
    		selecteds.add(resource.getId());
    	}
    	model.addAttribute("selecteds", selecteds);
        return "role/allot_resource";
    }
    
    /**
     * 
     * 保存 角色--资源
     *
     */
    @RequestMapping("/save_role_resource")
    public @ResponseBody BaseResponse saveResource(@RequestParam(name="roleId") String roleId,
    											   @RequestParam(name="resourceIds") String resourceIds) {

    	this.roleResourceService.save(roleId, resourceIds);
    	return BaseResponse.ok().message("资源分配成功");
    }
    
}
