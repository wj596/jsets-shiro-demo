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

import org.jsets.shiro.demo.domain.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文章管理(模拟业务)
 *
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
@Controller
@RequestMapping("/article")
public class ArticleAction {
	
	  @RequestMapping("/list")
	    public String index() {
	        return "article/article_list";
	    }
	    
	    @RequestMapping("/add")
	    public @ResponseBody BaseResponse add() {
	    	return BaseResponse.ok().message("文章添加成功，当然是模拟的");
	    }
	    
	    @RequestMapping("/delete")
	    public @ResponseBody BaseResponse delete() {
	    	return BaseResponse.ok().message("文章删除成功，当然是模拟的");
	    }
	    
	    @RequestMapping("/update")
	    public @ResponseBody BaseResponse update() {
	    	return BaseResponse.ok().message("文章修改成功，当然是模拟的");
	    }
	    
}