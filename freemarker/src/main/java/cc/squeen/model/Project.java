package cc.squeen.model;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer invId;
	private Integer type;
	private Integer status;
	private Date cTime;
	private Date bTime;
	private Date eTime;
	private String title;
	private String summary;
	private String client;
	private String responsibility;
	private String comment;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvId() {
		return invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCTime() {
		return cTime;
	}
	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

	public Date getBTime() {
		return bTime;
	}
	public void setBTime(Date bTime) {
		this.bTime = bTime;
	}

	public Date getETime() {
		return eTime;
	}
	public void setETime(Date eTime) {
		this.eTime = eTime;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}

	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}