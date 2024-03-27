package com.shivam.service;

import java.util.List;

import com.shivam.dto.PollCreationDto;
import com.shivam.dto.PollDetailDto;
import com.shivam.dto.PollInfoDto;
import com.shivam.dto.PollOptionDto;
import com.shivam.dto.SelectionInfoDto;
import com.shivam.dto.UserInfoDto;
import com.shivam.entity.PollInfo;
import com.shivam.entity.UserInfo;
import com.shivam.valueObject.PollStatistics;
import com.shivam.valueObject.UserNameAndPassword;
import com.shivam.valueObject.UserNameValueObject;

public interface PollService {

	UserNameValueObject verifyUser(UserNameAndPassword inputUser);

	UserInfoDto addOrUpdateUser(UserInfo newUser);

	PollInfoDto createPoll(PollCreationDto userAndPollInfo);

	List<PollInfoDto> getAllPollsByUserName(String userName);

	List<SelectionInfoDto> getAllVotedPolls(String userName);

	List<PollInfoDto> getActivePolls();

	//this can give error - we are making fake poll
	List<PollOptionDto> getPollOptions(Integer pollId);

	SelectionInfoDto saveVote(SelectionInfoDto choice);
	
	SelectionInfoDto updateVote(SelectionInfoDto choice);

	List<PollStatistics> getStatisticsOfPoll(Integer pollId);

	void changeStatus(Integer pollId, boolean status);

	PollDetailDto getPollFromId(Integer pollId);

	UserInfoDto getuserInfoByUserName(String userName);

}