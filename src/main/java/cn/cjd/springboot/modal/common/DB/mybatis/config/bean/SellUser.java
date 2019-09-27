package cn.cjd.springboot.modal.common.DB.mybatis.config.bean;

public class SellUser {
	private int id;					//编号ID
	private int carId;				//汽车ID
	private int userId;				//用户ID
	private String userName;		//卖家姓名
	private String userPhone;		//卖家手机号码
	private String userAddress;		//卖家地址		
	public SellUser() {
		super();
	}
	
	
	public SellUser(int id, int carId, int userId, String userName,
			String userPhone, String userAddress) {
		super();
		this.id = id;
		this.carId = carId;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	@Override
	public String toString() {
		return "SellUser [id=" + id + ", carId=" + carId + ", userId=" + userId
				+ ", userName=" + userName + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + "]";
	}

	

}
