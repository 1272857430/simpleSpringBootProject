package cn.cjd.springboot.modal.common.DB.mybatis.config.daoInterface;

import com.modal.common.DB.mybatis.config.bean.CarInfo;

import java.util.List;
import java.util.Map;

public interface ICarInfo {
	
	/*
	 * 查询出符合条件的汽车总数
	 */
	public int QueryCount(Map<String, Object> parameter);
	
		
	/*
	 * 查询出符合条件的汽车列表
	 */
	public List<CarInfo> QueryCarInfo(Map<String, Object> parameter);
		
	
	/*
	 * 查询最新汽车
	 */
	public List<CarInfo> QueryNewCar();
	
	/*
	 * 根据carId查询某辆汽车信息
	 */
	public CarInfo QueryCarInfoById(int carId);
	
	/*
	 * 添加汽车信息
	 */
	public void AddCarInfo(CarInfo carInfo);
	
	/*
	 * 根据userId分页汽车列表
	 */
	public List<CarInfo> QueryCarInfoByUserId(Map<String, Object> parameter);
	
	/*
	 * 根据userId查询汽车数目
	 * 
	 */
	public int QueryCountByUserId(int userId);
	
	/*
	 * 根据id删除某条汽车记录
	 */
	public void deleteOneByCarId(int carId);
	
	
	/**
	 * 分页查询汽车
	 * @param map
	 * @return
	 */
	public List<CarInfo> QueryCarByPage(Map<String, Object> map);
}
