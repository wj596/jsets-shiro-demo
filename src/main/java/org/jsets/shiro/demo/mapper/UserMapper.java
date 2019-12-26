package org.jsets.shiro.demo.mapper;

import java.util.List;
import java.util.Map;
import org.jsets.shiro.demo.domain.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户Mapper
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
public interface UserMapper extends BaseMapper<UserEntity> {
	int updateStatus(Map<String,Object> ps);
	UserEntity getByAccount(String account);
	List<UserEntity> selectUsers();
}