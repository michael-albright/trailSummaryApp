package com.tts.trailsummaryapp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.trailsummaryapp.model.TrailForm;
import com.tts.trailsummaryapp.repository.TrailFormRepository;

@Service
public class DataSummaryService {
	@Autowired
	TrailFormRepository trailFormRepository;

//	List<TrailForm> trailForms = trailFormRepository.findAll();

	/*
	 * THESE METHODS WILL BE LINKED UP THROUGH TRAILFORM CONTROLLER AND THEN USED IN
	 * HTML PAGE
	 */

	public String hikersAtNight() 
	{
		List<TrailForm> trailForms = trailFormRepository.findAll();
//	Integer currentBackpackers = 0;
		String str = "";
		for (TrailForm currentTrailForm : trailForms)
		{
			if (currentTrailForm.getNightsOnTrail() > 0)
			{
				Date start = currentTrailForm.getStartedAt();
				Date now = new Date();
				long diffInMillies = Math.abs(now.getTime() - start.getTime());
				long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				if(diff <= currentTrailForm.getNightsOnTrail())
					{
						str += "Name: " + currentTrailForm.getName() + "\n" +
								"Nights on Trail: " + currentTrailForm.getNightsOnTrail() + " || " + "Name of Trail: "
								+ currentTrailForm.getNameOfTrail() + " || " + "Emergency Contact: "
								+ currentTrailForm.getContactEmail() + " || " + "Location of Trail: "
								+ currentTrailForm.getLocation() + " || " +	"Date/Time Started: " + currentTrailForm.getStartedAt();
					}
			
			}
			
		}
		return str + "\n" + "\n";
	}
			

	
	/* METHOD TO SHOW WHO HAS HIKED WHAT*/
	
	//public String getTrailByName

	// Total Hikes Logged

	// Past Hikes
	public String getPastHikes() {
		List<TrailForm> trailForms = trailFormRepository.findAll();
		String str = "";
		for (TrailForm trailForm : trailForms) 
		{
			str += trailForm.getNameOfTrail() + "\n";
		}
		if (str.equals("")) {
			return "No Past Hikes \n";
			
		} else {
			
			return str;
		}
	}

	// Overnight trips
	public String getBackPackingTrips() {
		List<TrailForm> trailForms = trailFormRepository.findAll();
		for (TrailForm trailForm : trailForms) {
			if (trailForm.getNightsOnTrail() > 0)
				return trailForm.getNightsOnTrail() + "";
		}
		return "You have yet to go on a backpacking trip.";
	}
}




// String str = "Backpackers on Trail: " + currentBackpackers + " || " + "Name: " + currentTrailForm.getName()
//+ " || " + "Nights on Trail: " + currentTrailForm.getNightsOnTrail() + " || " + "Name of Trail: "
//+ currentTrailForm.getNameOfTrail() + " || " + "Emergency Contact: "
//+ currentTrailForm.getContactEmail() + " || " + "Location of Trail: "
//+ currentTrailForm.getLocation() + " || " +	"Date/Time Started: " + currentTrailForm.getStartedAt();
