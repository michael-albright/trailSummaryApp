package com.tts.trailsummaryapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class TrailForm 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull 
	@Email
	@NotEmpty
	private String contactEmail;
	
	@NotNull
	@NotEmpty
	private String nameOfTrail;
	
	@NotNull
	@Min(0)
	private Integer nightsOnTrail;
	
	@NotNull 
	@NotEmpty
	private String location;
	
	@Column
	@CreationTimestamp
	private Date startedAt;

	public TrailForm() {
		super();
	}

	public TrailForm(@NotNull String name, @NotNull String contactEmail, 
					@NotNull @Min(0) Integer nightsOnTrail, 
					@NotNull String nameOfTrail, 
					@NotNull String location, Date startedAt)
	{
		super();
		this.name = name;
		this.contactEmail = contactEmail;
		this.nameOfTrail = nameOfTrail;
		this.nightsOnTrail = nightsOnTrail;
		this.location = location;
		this.startedAt = startedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameOfTrail() {
		return nameOfTrail;
	}

	public void setNameOfTrail(String nameOfTrail) {
		this.nameOfTrail = nameOfTrail;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Integer getNightsOnTrail() {
		return nightsOnTrail;
	}

	public void setNightsOnTrail(Integer nightsOnTrail) {
		this.nightsOnTrail = nightsOnTrail;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public String toString()
	{
		return "Details(ID: " + id + "Name: " + this.name + "Nights out on Trail: "
					+ this.nightsOnTrail + "Name of Trail: " + this.nameOfTrail +
					"Emergency Contact: " + this.contactEmail + "Location of Trail: " 
					+ this.location + "Start Date/Time: " + this.startedAt + ")";
	}
	
	
}


