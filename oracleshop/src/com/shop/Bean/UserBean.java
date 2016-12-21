package com.shop.Bean;

public class UserBean {
	private int t_userid;
	private String  t_nickname;
	private String t_name;
	private String t_tel;
	private String t_address;
	private String t_userpsw;
	public int getT_userid() {
		return t_userid;
	}
	public void setT_userid(int t_userid) {
		this.t_userid = t_userid;
	}
	public String getT_nickname() {
		return t_nickname;
	}
	public void setT_nickname(String t_nickname) {
		this.t_nickname = t_nickname;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_tel() {
		return t_tel;
	}
	public void setT_tel(String t_tel) {
		this.t_tel = t_tel;
	}
	public String getT_address() {
		return t_address;
	}
	public void setT_address(String t_address) {
		this.t_address = t_address;
	}
	public String getT_userpsw() {
		return t_userpsw;
	}
	public void setT_userpsw(String t_userpsw) {
		this.t_userpsw = t_userpsw;
	}
	@Override
	public String toString() {
		return "UserBean [t_userid=" + t_userid + ", t_nickname=" + t_nickname
				+ ", t_name=" + t_name + ", t_tel=" + t_tel + ", t_address="
				+ t_address + ", t_userpsw=" + t_userpsw + "]";
	}
	
	
	
	
	
	

}
