package com.jsp.hibernate.queries.enitity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
	@Id
	private int actorId;
	private String actorName;
	private int actorAge;
	private String actorIndustry;
	private String nationality;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getActorAge() {
		return actorAge;
	}

	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}

	public String getActorIndustry() {
		return actorIndustry;
	}

	public void setActorIndustry(String actorIndustry) {
		this.actorIndustry = actorIndustry;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAge=" + actorAge + ", actorIndustry="
				+ actorIndustry + ", nationality=" + nationality + "]";
	}

}
