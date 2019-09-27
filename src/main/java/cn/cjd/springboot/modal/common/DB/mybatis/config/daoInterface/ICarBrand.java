package cn.cjd.springboot.modal.common.DB.mybatis.config.daoInterface;


import com.modal.common.DB.mybatis.config.bean.CarBrand;

/**
 * 与CarBrand.xml文件相对应的接口
 * @author chengjiade
 *
 */
public interface ICarBrand {

	/*
	 * 定义查找品牌对应的Id的方法
	 */
	public int queryCarBrandId(CarBrand carBrand);
	
	
	/*
	 * 定义查找Id对应的品牌的方法
	 */
	public String queryCarBrand(int carBrandId);
	
	/*
	 * 模糊查询，查询品牌的Id
	 */
	public CarBrand queryTrueCarBrandId(String inp);
	
}
