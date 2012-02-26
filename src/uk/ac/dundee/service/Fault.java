package uk.ac.dundee.service;

public class Fault {
	private int faultid;
	private int userid;
	private String project;
	private String release;
	private String summary;
	private String details;
	private String Action;
	private String state;
	private String Investigated_by;
	
	
	public int getFaultid() {
		return faultid;
	}
	public void setFaultid(int faultid) {
		this.faultid = faultid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInvestigated_by() {
		return Investigated_by;
	}
	public void setInvestigated_by(String investigated_by) {
		Investigated_by = investigated_by;
	}

}
