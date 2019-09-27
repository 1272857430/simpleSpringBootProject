package com.modal.common.DB.mybatis.config.bean;

public class CarBrand {
	
	private int carBrandId;			//车品牌的ID
	private String carBrand;		//车品牌
	
	public CarBrand() {
		super();
	}

	public CarBrand(int carBrandId, String carBrand) {
		super();
		this.carBrandId = carBrandId;
		this.carBrand = carBrand;
	}

	public int getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(int carBrandId) {
		this.carBrandId = carBrandId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	@Override
	public String toString() {
		return "CarBrand [carBrandId=" + carBrandId + ", carBrand=" + carBrand
				+ "]";
	}
	
}
