package cc.squeen.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Integer id;
	private String userName;
	private Date birthday;
	private Date cTime;
	private Integer isValid;
	private Integer gender;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCTime() {
		return cTime;
	}
	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}


}