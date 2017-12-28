package org.jsets.shiro.demo.action;

import org.jsets.shiro.demo.domain.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleAction {
	
	  @RequestMapping("/list")
	    public String index() {
	        return "article/article-list";
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
