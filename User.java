package cc.squeen.model;

public class User {
	private Integer id;
	private String userName;
	private Date birthday;
	private Date cTime;
	private Integer isValid;

	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(Integer userName) {
		this.userName = userName;
	}
	public Date getbirthday() {
		return birthday;
	}
	public void setbirthday(Integer birthday) {
		this.birthday = birthday;
	}
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Integer cTime) {
		this.cTime = cTime;
	}
	public Integer getisValid() {
		return isValid;
	}
	public void setisValid(Integer isValid) {
		this.isValid = isValid;
	}

}