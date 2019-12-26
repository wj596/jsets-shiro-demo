package org.jsets.shiro.demo.mapper;

import java.util.List;
import org.jsets.shiro.demo.domain.entity.RoleEntity;
import org.jsets.shiro.model.RolePermRule;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 角色Mapper
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
public interface RoleMapper extends BaseMapper<RoleEntity> {
	List<RoleEntity> selectRoles();
	List<RolePermRule> selectRolePermRules();
}