package org.jsets.shiro.demo.mapper;

import java.util.List;
import org.jsets.shiro.demo.domain.entity.ResourceEntity;
import org.jsets.shiro.demo.domain.entity.RoleResourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface RoleResourceMapper extends BaseMapper<RoleResourceEntity>{
	int deleteResourceByRole(String roleId);
	List<ResourceEntity> selectResourcesByRole(String roleId);
}