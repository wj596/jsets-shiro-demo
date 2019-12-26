package org.jsets.shiro.demo.mapper;

import java.util.List;

import org.jsets.shiro.demo.domain.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户角色关联Mapper
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {
	int deleteByUser(String userId);
	List<String> selectUserRoles(String account);
}
