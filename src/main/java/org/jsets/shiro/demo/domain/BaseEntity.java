package org.jsets.shiro.demo.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.jsets.jdbc.metadata.IdGenerators;

/**
 * 基础实体
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年8月05日 
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator=IdGenerators.UUID)
	private String id;// 主键 uuid

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}