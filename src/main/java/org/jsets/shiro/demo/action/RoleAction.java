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
    public String index(Model model) {
    	model.addAttribute("roles", roleService.list());
        return "role/role-list";
    }
    
    @RequestMapping("/allot-resource")
    public String allotResource(@RequestParam(name="roleId") String roleId,Model model) {
    	
    	roleResourceService.resourceRoleMapping();
    	System.out.println("roleId:"+roleId);
    	model.addAttribute("roleId", roleId);
    	model.addAttribute("resources", resourceService.list());
    	List<String> selecteds = Lists.newArrayList();
    	for(ResourceEntity resource:roleResourceService.listResourceByRole(roleId)){
    		selecteds.add(resource.getId());
    	}
    	model.addAttribute("selecteds", selecteds);
        return "role/allot-resource";
    }
    
    @RequestMapping("/save-resource")
    public @ResponseBody BaseResponse saveResource(@RequestParam(name="roleId") String roleId,
    													@RequestParam(name="resourceIds") String resourceIds) {
    	System.out.println("roleId:"+roleId);
    	this.roleResourceService.save(roleId, resourceIds);
    	return BaseResponse.ok().message("资源分配成功");
    }
    
}
