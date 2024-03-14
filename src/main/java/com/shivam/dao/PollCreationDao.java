package com.shivam.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.entity.PollInfo;
import com.shivam.entity.PollOption;
import com.shivam.entity.SelectionInfo;
import com.shivam.repository.PollInfoRepository;
import com.shivam.repository.PollOptionsRepository;
import com.shivam.repository.SelectionInfoRepository;
import com.shivam.repository.UserInfoRepository;

@Repository
public class PollCreationDao {

	@Autowired
	UserInfoRepository userTable;
	
	@Autowired
	PollInfoRepository pollsTable;
	
	@Autowired
	PollOptionsRepository optionsTable;
	
	@Autowired
	SelectionInfoRepository selectionTable;
	
	public void check() {

//		PollInfo poll = new PollInfo();
//		poll.setUserName("suyesha");
//		poll.setPollName("city poll");
//		poll.setCreationTime(LocalDateTime.now());
//		poll.setActive(true);
//		
//		List<PollOption> l = new ArrayList<PollOption>();
//		
//		PollOption p1 = new PollOption();
//		p1.setOptionName("pune");
//		p1.setPollId(poll);
//		
//		PollOption p2 = new PollOption();
//		p2.setOptionName("amravati");
//		p2.setPollId(poll);
//		
//		PollOption p3 = new PollOption();
//		p3.setPollId(poll);
//		p3.setOptionName("kahipan");
//		
//		l.add(p1);
//		l.add(p2);
//		l.add(p3);
//		
//		pollsTable.saveAndFlush(poll);
//		optionsTable.saveAllAndFlush(l);
		
		SelectionInfo select = new SelectionInfo("suyesha", 1, 2);
		selectionTable.saveAndFlush(select);
	}
	
}
