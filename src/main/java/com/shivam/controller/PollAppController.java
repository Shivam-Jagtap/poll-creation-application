package com.shivam.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shivam.dao.PollCreationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PollAppController {

	@Autowired
	PollCreationDao pollCreationDao;
	
	@GetMapping("/get")
	public void getMethodName() {
		System.out.println("request recieved");
		pollCreationDao.check();
//		return new String();
	}
	
}
