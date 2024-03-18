package com.shivam.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shivam.dao.PollCreationDaoImpl;
import com.shivam.dto.PollCreationDto;
import com.shivam.dto.PollInfoDto;
import com.shivam.dto.PollOptionDto;
import com.shivam.dto.SelectionInfoDto;
import com.shivam.dto.UserInfoDto;
import com.shivam.entity.PollInfo;
import com.shivam.entity.UserInfo;
import com.shivam.service.PollService;
import com.shivam.valueObject.PollStatistics;
import com.shivam.valueObject.UserNameAndPassword;
import com.shivam.valueObject.UserNameObject;
import com.shivam.valueObject.UserNameValueObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@CrossOrigin
@RestController
@RequestMapping("poll")
public class PollAppController {
	
	@Autowired
	PollService pollService;
	
	@PostMapping("createpoll")
	public PollInfoDto createPoll(@RequestBody PollCreationDto poll) {
		System.out.println("In create poll controller :"+poll);
		return pollService.createPoll(poll);
	}
	
	@PostMapping("verify")
	public UserNameValueObject verifyUser(@RequestBody UserNameAndPassword input) {
		
		return pollService.verifyUser(input);
	}
	
	@PostMapping("adduser")
	public UserInfoDto addUser(@RequestBody UserInfo newUser) {
		return pollService.addOrUpdateUser(newUser);
	}
	
	@PutMapping("updateuser")
	public UserInfoDto updateUser(@RequestBody UserInfo newUser) {
		return pollService.addOrUpdateUser(newUser);
	}
	
	@GetMapping("getpolls/{userName}")
	public List<PollInfoDto> getPollsByUser(@PathVariable("userName") String userName){
		return pollService.getAllPollsByUserName(userName);
	}
	
	@GetMapping("getvotedpolls/{userName}")
	public List<SelectionInfoDto> getVotedPolls(@PathVariable("userName") String userName){
		return pollService.getAllVotedPolls(userName);
	}
	
	@GetMapping("availablepolls")
	public List<PollInfoDto> getAllActivePolls(){
		System.out.println("get request hit");
		return pollService.getActivePolls();
	}
	
	@GetMapping("options/{pollId}")
	public List<PollOptionDto> getOptions(@PathVariable("pollId") Integer pollId){
		return pollService.getPollOptions(pollId);
	}
	
	@PostMapping("savevote")
	public SelectionInfoDto saveVote(@RequestBody SelectionInfoDto choice) {
//		System.out.println("In controller , choice :"+choice);
		return pollService.saveVote(choice);
	}
	
	//not working properly
	@PutMapping("updatevote")
	public SelectionInfoDto updateVote(@RequestBody SelectionInfoDto choice) {
		return pollService.saveVote(choice);
	}
	
	@GetMapping("statistics/{pollId}")
	public List<PollStatistics> stats(@PathVariable("pollId") Integer pollId){
		return pollService.getStatisticsOfPoll(pollId);
	}
 
//	@GetMapping("change/{pollId}")
//	public String change(@PathVariable("pollId") Integer pollId) {
//		pollService.changeStatus(pollId, false);
//		return "done";
//	}
}
