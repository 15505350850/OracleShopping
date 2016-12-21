package com.shop.Bean;

public class ProductBean {
	private int t_productid;
	private String t_productname;
	private int t_price;
	private int t_num;
	private String t_productdate;
	private int t_postage;
	private String t_comment;
	@Override
	public String toString() {
		return "ProductBean [t_productid=" + t_productid + ", t_productname="
				+ t_productname + ", t_price=" + t_price + ", t_num=" + t_num
				+ ", t_productdate=" + t_productdate + ", t_postage="
				+ t_postage + ", t_comment=" + t_comment + "]";
	}
	public int getT_productid() {
		return t_productid;
	}
	public void setT_productid(int t_productid) {
		this.t_productid = t_productid;
	}
	public String getT_productname() {
		return t_productname;
	}
	public void setT_productname(String t_productname) {
		this.t_productname = t_productname;
	}
	public int getT_price() {
		return t_price;
	}
	public void setT_price(int t_price) {
		this.t_price = t_price;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getT_productdate() {
		return t_productdate;
	}
	public void setT_productdate(String t_productdate) {
		this.t_productdate = t_productdate;
	}
	public int getT_postage() {
		return t_postage;
	}
	public void setT_postage(int t_postage) {
		this.t_postage = t_postage;
	}
	public String getT_comment() {
		return t_comment;
	}
	public void setT_comment(String t_comment) {
		this.t_comment = t_comment;
	}
	

}
