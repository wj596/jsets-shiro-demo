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

import org.jsets.shiro.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源（菜单、按钮）管理
 * 
 * 这里只是展示一个列表
 *
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@Controller
@RequestMapping("/resource")
public class ResourceAction {
	
	@Autowired
	private ResourceService resourceService;
	
    @RequestMapping("/list")
    public String list(Model model) {
    	model.addAttribute("resources", resourceService.list());
        return "resource/resource_list";
    }

    
}