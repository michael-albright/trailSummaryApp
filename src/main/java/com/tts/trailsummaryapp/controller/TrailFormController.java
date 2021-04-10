package com.tts.trailsummaryapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tts.trailsummaryapp.model.TrailForm;
import com.tts.trailsummaryapp.repository.TrailFormRepository;

@Controller
public class TrailFormController implements WebMvcConfigurer
{
	@Autowired
	private TrailFormRepository trailFormRepository;
	
	@GetMapping("/")
	public String showTrailForm(TrailForm trailForm)
	{
		return "index";
	}
	
	//**ADDED A GETMAPPING FOR THE LOGIN PAGE
	@GetMapping("/login")
	public String showLogin()
	{
		return "login";
	}
	
	@PostMapping("/")
	public String addNewHiker(@Valid TrailForm hiker, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
			return "index";
		} else {
			trailFormRepository.save(new TrailForm(hiker.getFirstName(), hiker.getLastName(), 
					hiker.getAmountOfHikers(), hiker.getNightsOnTrail(), hiker.getStartedAt()));
			
			model.addAttribute("First Name", hiker.getFirstName());
			model.addAttribute("Last Name", hiker.getLastName());
			model.addAttribute("Amount of Hikers", hiker.getAmountOfHikers());
			model.addAttribute("Nights on Trail", hiker.getNightsOnTrail());
			model.addAttribute("Started Trail At", hiker.getStartedAt());
			return "trailMap";
		}
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/trailMap").setViewName("trailMap");
	}

}
