package com.atguigu.bean;

import java.util.Date;
import java.util.List;

public class MyT_mall_attr {
	private int id;
	private String shxm_mch;
	private String shfqy;
	private int flbh2;
	private Date chjshj;
	private List<T_mall_value> valueList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShxm_mch() {
		return shxm_mch;
	}

	public void setShxm_mch(String shxm_mch) {
		this.shxm_mch = shxm_mch;
	}

	public String getShfqy() {
		return shfqy;
	}

	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}

	public int getFlbh2() {
		return flbh2;
	}

	public void setFlbh2(int flbh2) {
		this.flbh2 = flbh2;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	public List<T_mall_value> getValueList() {
		return valueList;
	}

	public void setValueList(List<T_mall_value> valueList) {
		this.valueList = valueList;
	}
}
