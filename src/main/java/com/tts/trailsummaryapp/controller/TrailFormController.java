package com.tts.trailsummaryapp.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.GenerationType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tts.trailsummaryapp.model.TrailForm;
import com.tts.trailsummaryapp.repository.TrailFormRepository;
import com.tts.trailsummaryapp.service.DataSummaryService;
import com.tts.trailsummaryapp.service.EmailService;
import com.tts.trailsummaryapp.service.TrailFormService;

@Controller
public class TrailFormController implements WebMvcConfigurer
{	
	@Autowired
	private DataSummaryService dataSummaryService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TrailFormService trailFormService;
	
	@Autowired
	private TrailFormRepository trailFormRepository;
	
	@GetMapping("/")
	public String showTrailForm(TrailForm trailForm)
	{
		return "index";
	}
	
	@GetMapping("/index")
	public String showHomePage(TrailForm trailForm)
	{
		return "index";
	}
	
	//**ADDED A GETMAPPING FOR THE LOGIN PAGE
	@GetMapping("/login")
	public String showLogin()
	{
		return "login";
	}
	
	/* THE METHODS IN DATA SUMMARY GET CALLED ON HERE AND THEN USED IN HTML f.e. <p th:text${details}> </p> */
	@GetMapping("/dataSummary")
	public String showBackpackersStats(Model model)
	{
	/* EACH METHOD IS RAN INTO THYMELEAF BELOW */
		String str1 = dataSummaryService.hikersAtNight();
		model.addAttribute("details", str1);
		String str2 = dataSummaryService.getPastHikes();
		model.addAttribute("trails", str2);
		String str3 = dataSummaryService.getBackPackingTrips();
		model.addAttribute("trips", str3);
		return "dataSummary";
	}
	
//	@GetMapping("/confirmation")
//	public String showEmailForm(Model model)
//	{
//		String emailSent = trailFormServicegetEmailSent();
//		model.addAttribute("info", emailSent);
//		return "confirmation";
//	}
	
//	public String addNewHiker(@Valid TrailForm hiker, BindingResult bindingResult, Model model)
//	{
//		if(bindingResult.hasErrors()) {
//			return "index";
//		} else {
//			hiker = trailFormRepository.save(hiker);
//			model.addAttribute("name", hiker.getName());
//			model.addAttribute("contactEmail", hiker.getContactEmail());
//			model.addAttribute("nightsOnTrail", hiker.getNightsOnTrail());
//			model.addAttribute("nameOfTrail", hiker.getNameOfTrail());
//			model.addAttribute("location", hiker.getLocation());
//			model.addAttribute("startedTrailAt", hiker.getStartedAt());

	
	@PostMapping("/")
	public String addNewHiker(@Valid TrailForm trailForm, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
			return "index";
		} else {
			trailForm = trailFormRepository.save(trailForm);
			model.addAttribute("trailForm", trailForm);
			model.addAttribute("name", trailForm.getName());
			model.addAttribute("contactEmail", trailForm.getContactEmail());
			model.addAttribute("nightsOnTrail", trailForm.getNightsOnTrail());
			model.addAttribute("nameOfTrail", trailForm.getNameOfTrail());
			model.addAttribute("location", trailForm.getLocation());
			model.addAttribute("startedTrailAt", trailForm.getStartedAt());
			
			
//			String email = hiker.getContactEmail();
//			
//			//**right here i need to run a test to see if the email is legit
//			
//			String title = "**Your BUDDY is HIKING**";
//			
//			String emailMessage = "Name: " + hiker.getName() + " || " +
//					"Nights on Trail: " + hiker.getNightsOnTrail() + " || " +
//					"Name of Trail: " + hiker.getNameOfTrail() + " || " + 
//					"Emergency Contact: " + hiker.getContactEmail() + " || " +
//					"Location of Trail: " + hiker.getLocation() + " || " +
//					"Date/Time Started: " + hiker.getStartedAt();
//		
//					emailService.sendMail(email, title, emailMessage);

	
	/* BELOW IS THE CALL TO RUN THE EMAIL RESPONSE */		
	
			String email = trailForm.getContactEmail();
			
			//**right here i need to run a test to see if the email is legit
			
			String title = "**Your BUDDY is HIKING**";
			
			String emailMessage = "Name: " + trailForm.getName() + " || " +
					"Nights on Trail: " + trailForm.getNightsOnTrail() + " || " +
					"Name of Trail: " + trailForm.getNameOfTrail() + " || " + 
					"Emergency Contact: " + trailForm.getContactEmail() + " || " +
					"Location of Trail: " + trailForm.getLocation() + " || " +
					"Date/Time Started: " + trailForm.getStartedAt();
		
					emailService.sendMail(email, title, emailMessage);
					
			return "confirmation";
		}
		
	}

}
	
	//SCOTTS EXAMPLE
//	@GetMapping("/dataSummary")
//	public String showBackpackers(Model model)
//	{
//	        String dummySummary = trailFormService.hikersAtNight();
//	        model.addAttribute("summary", dummySummary);
//	       return "dataSummary";
//	}
	

	
	

