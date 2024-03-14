package com.shivam.dao;

import java.util.List;

import com.shivam.entity.PollInfo;
import com.shivam.entity.PollOption;
import com.shivam.entity.SelectionInfo;
import com.shivam.entity.UserInfo;

public interface PollDao {

	UserInfo getUser(String userName);

	UserInfo addUser(UserInfo newUser);

	PollInfo createPoll(PollInfo poll, List<PollOption> options);

	List<PollInfo> allCreatedPolls(String userName);

	List<SelectionInfo> votedPolls(String userName);

	List<PollInfo> activePolls();

//	List<PollOption> getOptionsForPoll(Integer pollId);

	SelectionInfo saveOption(SelectionInfo selectedOption);

	List<SelectionInfo> getSelectionByPollId(Integer pollId);

	List<PollOption> getOptionsForPoll(PollInfo pollId);

	String getOptionName(Integer optionId);

}