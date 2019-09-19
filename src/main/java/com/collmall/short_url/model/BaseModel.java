package com.collmall.short_url.model;


import cn.hutool.core.date.DateUtil;

import java.io.Serializable;

/**
 * 基本base
 * @author xulihui
 * @data 2019-09-19
 */
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = -5197016274254911057L;

	private Long id;
	private Long cT;
	private Long uT;
	private Boolean isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getcT() {
		if(cT==null)
			cT= DateUtil.currentSeconds();
		return cT;
	}

	public Long getuT() {
		if(uT==null)
			uT= DateUtil.currentSeconds();
		return uT;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}
}
