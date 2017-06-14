package com.atguigu.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MyT_mall_sku {

	private int id;
	private int shp_id;
	private int kc;
	private BigDecimal jg;
	private Date chjshj;
	private String sku_mch;
	private String kcdz;

	private List<T_mall_product_image> images;

	private List<My_attr_value> attrvalues;

	public List<T_mall_product_image> getImages() {
		return images;
	}

	public void setImages(List<T_mall_product_image> images) {
		this.images = images;
	}

	public List<My_attr_value> getAttrvalues() {
		return attrvalues;
	}

	public void setAttrvalues(List<My_attr_value> attrvalues) {
		this.attrvalues = attrvalues;
	}

	private T_mall_product spu;
	private T_mall_trade_mark trademark;

	public T_mall_product getSpu() {
		return spu;
	}

	public void setSpu(T_mall_product spu) {
		this.spu = spu;
	}

	public T_mall_trade_mark getTrademark() {
		return trademark;
	}

	public void setTrademark(T_mall_trade_mark trademark) {
		this.trademark = trademark;
	}

	public String getKcdz() {
		return kcdz;
	}

	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShp_id() {
		return shp_id;
	}

	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	public int getKc() {
		return kc;
	}

	public void setKc(int kc) {
		this.kc = kc;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	public String getSku_mch() {
		return sku_mch;
	}

	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}

	public BigDecimal getJg() {
		return jg;
	}

	public void setJg(BigDecimal jg) {
		this.jg = jg;
	}
}
