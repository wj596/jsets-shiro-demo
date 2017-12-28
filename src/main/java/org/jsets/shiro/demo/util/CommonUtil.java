package org.jsets.shiro.demo.util;

import java.util.Date;
import java.util.Set;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

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
}
