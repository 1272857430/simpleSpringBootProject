package com.modal.common.DB.mybatis.config.bean;

/**
 * 管理员用户实体类
 * @author chengjiade
 *
 */
public class Admin {
	private int id;				//用户ID
	private String name;		//用户名
	private String password;	//密码
	
	public Admin() {
		super();
	}

	public Admin(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
	
	
}

