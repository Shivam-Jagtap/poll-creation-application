package com.shivam.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.entity.PollInfo;
import com.shivam.entity.PollOption;
import com.shivam.entity.SelectionInfo;
import com.shivam.entity.UserInfo;
import com.shivam.repository.PollInfoRepository;
import com.shivam.repository.PollOptionsRepository;
import com.shivam.repository.SelectionInfoRepository;
import com.shivam.repository.UserInfoRepository;

@Repository
public class PollCreationDaoImpl implements PollDao {

	@Autowired
	UserInfoRepository userTable;
	
	@Autowired
	PollInfoRepository pollsTable;
	
	@Autowired
	PollOptionsRepository optionsTable;
	
	@Autowired
	SelectionInfoRepository selectionTable;

	@Override
	public UserInfo getUser(String userName) { // can be used for verification
		UserInfo user = userTable.getReferenceById(userName);
		return user;
	}
	
	@Override
	public UserInfo addUser(UserInfo newUser) { //adding new user to db
		return userTable.saveAndFlush(newUser);
	}
	
	@Override
	public PollInfo createPoll(PollInfo poll, List<PollOption> options) {
		PollInfo createdPoll = pollsTable.saveAndFlush(poll);
		optionsTable.saveAllAndFlush(options);
		return createdPoll;
	}
	
	@Override
	public List<PollInfo> allCreatedPolls(String userName){//gives all the polls related to a username
		return pollsTable.findByUserName(userName);
	}
	
	@Override
	public List<SelectionInfo> votedPolls(String userName) {// give all pollid and selected optionid for a user
		return selectionTable.findByUserName(userName);
	}
	
	@Override
	public List<PollInfo> activePolls() {// return all active polls
		return pollsTable.findByActive(true);			
	}
	
	@Override
	public List<PollOption> getOptionsForPoll(PollInfo pollId) {//give all options for single poll
		return optionsTable.findByPollId(pollId);
	}
	
	@Override
	public SelectionInfo saveOption(SelectionInfo selectedOption) {//it save the selected option for user,can also be used for updating vote
		return selectionTable.saveAndFlush(selectedOption);
	}
	
	@Override
	public List<SelectionInfo> getSelectionByPollId(Integer pollId) {// can be used for statistics and calculati
		return selectionTable.findByPollId(pollId);
	}
	
	@Override
	public String getOptionName(Integer optionId) {
		Optional<PollOption> poll =  optionsTable.findById(optionId);
		return poll.get().getOptionName();
	}
	
	@Override
	public void updateOption(Integer optionId, String userName) {
		// TODO Auto-generated method stub
		selectionTable.updateVote(optionId, userName);
	}
	
	@Override
	public void changeStatus(Integer pollId,boolean status) {
		pollsTable.changeActiveStatus(pollId, status);
	}
}
