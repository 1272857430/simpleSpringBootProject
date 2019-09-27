package cn.cjd.springboot.modal.common.DB.mybatis.config.bean;

/**
 * 买车用户的实体类
 * @author chengjiade
 *
 */
public class User {
	private int userId;				//用户ID
	private String userName;		//用户名
	private	String userSex;			//性别
	private String realName;		//真实姓名
	private String userPassword;	//密码
	private String userCard;		//身份证
	private String userPhone;		//手机电话号码
	



	@Override
	public String toString() {
		return "User [userId=" + userId + ", realName=" + realName
				+ ", userName=" + userName + ", userSex=" + userSex
				+ ", userPassword=" + userPassword + ", userCard=" + userCard
				+ ", userPhone=" + userPhone + "]";
	}



	public User() {
		super();
	}

	public User(int userId, String realName, String userName, String userSex,
			String userPassword, String userCard, String userPhone) {
		super();
		this.userId = userId;
		this.realName = realName;
		this.userName = userName;
		this.userSex = userSex;
		this.userPassword = userPassword;
		this.userCard = userCard;
		this.userPhone = userPhone;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	public String getUserSex() {
		return userSex;
	}



	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}



	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}		
	
}
