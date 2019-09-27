package cn.cjd.springboot.modal.common.DB.mybatis.config.daoInterface;


import com.modal.common.DB.mybatis.config.bean.SellUser;

import java.util.List;
import java.util.Map;

public interface ISellUser {
	/*
	 * 查询SellUser列表
	 */
	public List<SellUser> QuerySellUser(int carId);
	
	/*
	 * 查询SellUser列表
	 */
	public List<SellUser> QuerySellUserByPage(Map<String, Object> map);
	
	/*
	 * 查询SellUser总数
	 */
	public int QuerySellUserCountByAdmin(Map<String, Object> map);
	
	/*
	 * 删除SellUser
	 */
	public void DeleteSellUser(int sellUserId);
}
