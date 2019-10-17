package cn.cjd.springboot.modal.db_use.mybatis.config.daoInterface;

import cn.cjd.springboot.modal.db_use.mybatis.config.bean.Admin;

/**
 * 与Admin.xml文件相对应的接口
 * @author chengjiade
 *
 */
public interface IAdmin {

	/*
	 * 根据用户名查询管理员信息
	 */
	public int queryAdminCount(Admin admin);
}
