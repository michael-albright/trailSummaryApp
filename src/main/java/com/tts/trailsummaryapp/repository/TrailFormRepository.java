package com.tts.trailsummaryapp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.trailsummaryapp.model.TrailForm;

public interface TrailFormRepository extends CrudRepository<TrailForm, Long> 
{
	List<TrailForm> findByName(String name);
	List<TrailForm> findByContactEmail(String contactEmail);
	List<TrailForm> findByNameOfTrail(String nameOfTrail);
	List<TrailForm> findByNightsOnTrail(Integer nightsOnTrail);
	List<TrailForm> findByLocation(String location);
	@Override
	List<TrailForm> findAll();
	
	//added this findBy....
	List<TrailForm> findByStartedAt(Date startedAt);
}
