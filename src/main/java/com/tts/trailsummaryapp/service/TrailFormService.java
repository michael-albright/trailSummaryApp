package com.tts.trailsummaryapp.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.trailsummaryapp.model.TrailForm;
import com.tts.trailsummaryapp.repository.TrailFormRepository;

@Service
public class TrailFormService 

{
	@Autowired
	private TrailFormRepository trailFormRepository;
	
	
	public List<TrailForm> findByFirstName(String name)
	{
		return trailFormRepository.findByName(name);
	}
	
	public List<TrailForm> findByContactEmail(String contactEmail)
	{
		return trailFormRepository.findByContactEmail(contactEmail);
	}
	
	public List<TrailForm> findByNameOfTrail(String nameOfTrail)
	{
		return trailFormRepository.findByNameOfTrail(nameOfTrail);
	}
	
	public List<TrailForm> findByNightsOnTrail(Integer nightsOnTrail)
	{
		return trailFormRepository.findByNightsOnTrail(nightsOnTrail);
	}
	
	//new
	public List<TrailForm> findByLocation(String location)
	{
		return trailFormRepository.findByLocation(location);
	}
	
	//new 
	public List<TrailForm> findByStartedAt(Date startedAt)
	{
		return trailFormRepository.findByStartedAt(startedAt);
	}
	
}
	

	
//	public String gethikersAtNight()
//	{
//		if(hikersAtNight() == true)
//			return "Name: " + currentTrailForm.getFirstName() + "\n" +
//					"Amount of Hikers: " + currentTrailForm.getAmountOfHikers() + "\n" + 
//					"Date/Time Started: " + currentTrailForm.getStartedAt();
//	}
	

	
	
//	public List<TrailForm> onTrailToday()
//	{	
//		
//		for(int i=0; i < trailForm.size(); i++)
//		{
//			
//		}
//	}
	
	
/*			("Name: " + currentTrailForm.getFirstName() + "\n" +
	"Amount of Hikers: " + currentTrailForm.getAmountOfHikers() + "\n" + 
	"Date/Time Started: " + currentTrailForm.getStartedAt());
	
}

	
	*/