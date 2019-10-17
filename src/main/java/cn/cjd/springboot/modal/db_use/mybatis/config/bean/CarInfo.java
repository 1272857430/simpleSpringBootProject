package cn.cjd.springboot.modal.db_use.mybatis.config.bean;

import java.sql.Timestamp;

/**
 * 汽车信息表实体类
 * @author chengjiade
 *
 */
public class CarInfo {
	private int id;					//编号id
	private int carId;				//车的ID
	private int userId;				//车主ID
	private int carBrandId;			//车品牌ID
	private int carTypeId;			//车类型ID
	private String carName;			//车名
	private int carPrice;			//车价格
	private String carDescription;	//汽车描述
	private int carAge;				//车龄
	private String carPicture;		//汽车图片
	private Timestamp upTime;		//上架时间
	
	public CarInfo() {
		super();
	}

	public CarInfo(int id, int carId, int userId, int carBrandId,
			int carTypeId, String carName, int carPrice,
			String carDescription, int carAge, String carPicture,
			Timestamp uptime) {
		super();
		this.id = id;
		this.carId = carId;
		this.userId = userId;
		this.carBrandId = carBrandId;
		this.carTypeId = carTypeId;
		this.carName = carName;
		this.carPrice = carPrice;
		this.carDescription = carDescription;
		this.carAge = carAge;
		this.carPicture = carPicture;
		this.upTime = uptime;
	}

	public Timestamp getUptime() {
		return upTime;
	}

	public void setUptime(Timestamp upTime) {
		this.upTime = upTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(int carBrandId) {
		this.carBrandId = carBrandId;
	}

	public int getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(int carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}
	
	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}

	public String getCarPicture() {
		return carPicture;
	}

	public void setCarPicture(String carPicture) {
		this.carPicture = carPicture;
	}

	@Override
	public String toString() {
		return "CarInfo [id=" + id + ", carId=" + carId + ", userId=" + userId
				+ ", carBrandId=" + carBrandId + ", carTypeId=" + carTypeId
				+ ", carName=" + carName + ", carPrice=" + carPrice
				+ ", carDescription=" + carDescription + ", carAge=" + carAge
				+ ", carPicture=" + carPicture + ", upTime=" + upTime + "]";
	}
	
}
