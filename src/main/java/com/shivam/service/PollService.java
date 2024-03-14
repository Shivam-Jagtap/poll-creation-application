package com.shivam.service;

import java.util.List;

import com.shivam.dto.PollCreationDto;
import com.shivam.dto.PollInfoDto;
import com.shivam.dto.PollOptionDto;
import com.shivam.dto.SelectionInfoDto;
import com.shivam.entity.PollInfo;
import com.shivam.entity.UserInfo;
import com.shivam.valueObject.PollStatistics;
import com.shivam.valueObject.UserNameAndPassword;

public interface PollService {

	String verifyUser(UserNameAndPassword inputUser);

	UserInfo addOrUpdateUser(UserInfo newUser);

	PollInfoDto createPoll(PollCreationDto userAndPollInfo);

	List<PollInfoDto> getAllPollsByUserName(String userName);

	List<SelectionInfoDto> getAllVotedPolls(String userName);

	List<PollInfoDto> getActivePolls();

	//this can give error - we are making fake poll
	List<PollOptionDto> getPollOptions(Integer pollId);

	// can be also used for update
	SelectionInfoDto saveVote(SelectionInfoDto choice);

	List<PollStatistics> getStatisticsOfPoll(Integer pollId);

}