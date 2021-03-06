package cn.cjd.springboot.modal.db_use.mybatis.config.daoInterface;

import cn.cjd.springboot.modal.db_use.mybatis.config.bean.CarType;

/**
 * 与CarType对应的接口
 * @author chengjiade
 *
 */
public interface ICarType {
	
	/*
	 * 定义查询carTypeId的抽象方法
	 */
	public int querycarTypeId(CarType carType);
	
	
	/*
	 * 定义查询carType的抽象方法
	 */
	public String querycarType(int carTypeId);
	
	/*
	 * 模糊查询carTypeId的抽象方法
	 */
	public CarType queryTruecarTypeId(String carType);
}
