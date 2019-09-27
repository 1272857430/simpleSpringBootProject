package cn.cjd.springboot.modal.common.DB.mybatis.config.bean;

/**
 * 汽车类型实体类
 * @author chengjiade
 *
 */
public class CarType {
	private int carTypeId;			//车类型的ID
	private String carType;			//车类型
	
	public CarType() {
		super();
	}

	public CarType(int carTypeId, String carType) {
		super();
		this.carTypeId = carTypeId;
		this.carType = carType;
	}

	public int getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(int carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "CarType [carTypeId=" + carTypeId + ", carType=" + carType + "]";
	}	
	
}
