package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Meeting;
import net.javaguides.springboot.service.MeetingService;

//creating method handler for index.html to display a list of meetings
@Controller
public class MeetingController {

	@Autowired
	private MeetingService meetingService;
	//display list of meetings
	@GetMapping("/")
	public String viewHomePage(Model model) {	
		model.addAttribute("listMeetings",meetingService.getAllMeeting());
		return "index";
	}
	
	@GetMapping("/showNewMeetingForm")
	public String showNewMeetingForm(Model model) {
		//create model attribute to bind form data
		Meeting meeting=new Meeting();
		model.addAttribute("meeting",meeting);
		return "new_meeting";
	}
	
	@PostMapping("/saveMeeting")
	public String saveMeeting(@ModelAttribute("meeting")Meeting meeting) {
		//save meeting to DB
		meetingService.saveMeeting(meeting);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
		
		// get meeting from the service
		Meeting meeting=meetingService.getMeetingById(id);
		
		// set meeting as a model attribute to pre-populate the form
		model.addAttribute("meeting",meeting);
		return "update_meeting";
	}
	@GetMapping("/deleteMeeting/{id}")
	public String deleteMeeting(@PathVariable(value="id") long id) {
		//call delete meeting
		this.meetingService.deleteMeetingById(id);
		return "redirect:/";
		
	}
}
