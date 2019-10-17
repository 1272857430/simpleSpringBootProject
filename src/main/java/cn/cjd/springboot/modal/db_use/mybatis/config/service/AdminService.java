package cn.cjd.springboot.modal.db_use.mybatis.config.service;

import cn.cjd.springboot.modal.db_use.mybatis.DBAccess;
import cn.cjd.springboot.modal.db_use.mybatis.config.bean.Admin;
import cn.cjd.springboot.modal.db_use.mybatis.config.daoInterface.IAdmin;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * 和admin表相关的数据库操作
 * 
 * @author chengjiade
 */
public class AdminService {

	/*
	 * 查询管理员是否符合条件
	 */
	public boolean judge(Admin admin) {
		DBAccess dBAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dBAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IAdmin iadmin = sqlSession.getMapper(IAdmin.class);
			result = iadmin.queryAdminCount(admin);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
}
