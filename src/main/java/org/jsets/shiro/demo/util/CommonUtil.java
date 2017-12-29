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
package org.jsets.shiro.demo.util;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * 一些工具方法
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
 */ 
public abstract class CommonUtil {

	/**
	 * 现在-日期类型
	 */
	public static Date nowDate() {
		return new Date();
	}
	
	
	/**
	 * 分割字符串进SET
	 */
	public static Set<String> split(String str) {
		return split(str, ",");
	}

	/**
	 * 分割字符串进SET
	 */
	public static Set<String> split(String str, String separator) {
		Set<String> set = Sets.newLinkedHashSet();
		if (Strings.isNullOrEmpty(str))
			return set;
		for (String s : str.split(separator)) {
			set.add(s);
		}
		return set;
	}
	/**
	 * 逗号连接字符串
	 */
	public static String join(Collection<String> strs) {
		StringBuilder sb = new StringBuilder();
		for(String str:strs){
			if(sb.length()>0) sb.append(",");
			sb.append(str);
		}
		return sb.toString();
	}
}
