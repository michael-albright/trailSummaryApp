package com.tts.trailsummaryapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Min(0)
	private Integer amountOfHikers;
	
	@NotNull
	@Min(0)
	@Max(7)
	private Integer nightsOnTrail;
	
	@Column
	@CreationTimestamp
	private Date startedAt;

	public TrailForm() {
		super();
	}

	public TrailForm(@NotNull String firstName, @NotNull String lastName, @NotNull @Min(0) Integer amountOfHikers,
						@NotNull @Min(0) @Max(7) Integer nightsOnTrail, Date startedAt)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.amountOfHikers = amountOfHikers;
		this.nightsOnTrail = nightsOnTrail;
		this.startedAt = startedAt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAmountOfHikers() {
		return amountOfHikers;
	}

	public void setAmountOfHikers(Integer amountOfHikers) {
		this.amountOfHikers = amountOfHikers;
	}

	public Integer getNightsOnTrail() {
		return nightsOnTrail;
	}

	public void setNightsOnTrail(Integer nightsOnTrail) {
		this.nightsOnTrail = nightsOnTrail;
	}
	
	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public String toString()
	{
		return "Details(ID: " + id + "First Name: " + this.firstName + 
				"Last Name: " + this.lastName + "Amount of Hikers: " + 
				this.amountOfHikers + "Nights out on Trail: " + this.nightsOnTrail +
				"Start Date/Time: " + this.startedAt + ")";
	}
	
	
}


