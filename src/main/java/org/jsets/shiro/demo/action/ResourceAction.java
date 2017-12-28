package org.jsets.shiro.demo.action;

import org.jsets.shiro.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resource")
public class ResourceAction {
	
	@Autowired
	private ResourceService resourceService;
	
    @RequestMapping("/list")
    public String index(Model model) {
    	model.addAttribute("resources", resourceService.list());
        return "res/res-list";
    }
    
   
    
}
