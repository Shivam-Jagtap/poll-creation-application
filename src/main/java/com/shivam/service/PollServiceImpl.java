package com.shivam.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.dao.PollDao;
import com.shivam.dto.PollCreationDto;
import com.shivam.dto.PollInfoDto;
import com.shivam.dto.PollOptionDto;
import com.shivam.dto.SelectionInfoDto;
import com.shivam.dto.UserInfoDto;
import com.shivam.entity.PollInfo;
import com.shivam.entity.PollOption;
import com.shivam.entity.SelectionInfo;
import com.shivam.entity.UserInfo;
import com.shivam.valueObject.PollStatistics;
import com.shivam.valueObject.UserNameAndPassword;
import com.shivam.valueObject.UserNameValueObject;

@Service
public class PollServiceImpl implements PollService {
	
	@Autowired
	PollDao pollDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public UserNameValueObject verifyUser(UserNameAndPassword inputUser) {
		UserInfo user = pollDao.getUser(inputUser.getUserName());
		
		System.out.println("in service "+user);
		UserNameValueObject userr = new UserNameValueObject();
//		userr.setUserName(null);
		if(user.getPassword().equals(inputUser.getPassword())) {
			userr.setUserName(user.getUserName());
			return userr;
		}
		return userr;
	}
	
	@Override
	public UserInfoDto addOrUpdateUser(UserInfo newUser) {
		UserInfo user = new UserInfo();
//		System.out.println("In adduser service newUser : "+newUser);
		user = pollDao.addUser(newUser);
//		System.out.println("In adduser service addeduser : "+user);

		UserInfoDto userr = mapper.map(user, UserInfoDto.class);
		return userr;
	}
	
	@Override
	public PollInfoDto createPoll(PollCreationDto userAndPollInfo) {
		PollInfo newPoll = new PollInfo();
		newPoll.setUserName(userAndPollInfo.getUserName());
		newPoll.setPollName(userAndPollInfo.getPollName());
		newPoll.setActive(true);
		newPoll.setCreationTime(LocalDateTime.now());
		
		// set options
		List<PollOption> optionsToSave = new ArrayList<>();
		List<String> options = userAndPollInfo.getOptionName();
		for(String option : options) {
			PollOption o = new PollOption();
			o.setOptionName(option);
			o.setPollId(newPoll);
			optionsToSave.add(o);
		}
		PollInfo p =  pollDao.createPoll(newPoll, optionsToSave);
		
		return mapper.map(p, PollInfoDto.class);
	}
	
	@Override
	public List<PollInfoDto> getAllPollsByUserName(String userName) {
		List<PollInfo> list =  pollDao.allCreatedPolls(userName);
		List<PollInfoDto> dtoList = new ArrayList<>();
		
		for(PollInfo p : list) {
			PollInfoDto p2 = mapper.map(p, PollInfoDto.class);
			dtoList.add(p2);
		}
		return dtoList;
	}
	
	@Override
	public List<SelectionInfoDto> getAllVotedPolls(String userName) {
		List<SelectionInfo> list = pollDao.votedPolls(userName);
		List<SelectionInfoDto> dtoList = new ArrayList();
		
		for(SelectionInfo s : list) {
			dtoList.add(mapper.map(s, SelectionInfoDto.class));
		}
		return dtoList;
	}
	
	@Override
	public List<PollInfoDto> getActivePolls(){
		List<PollInfo> li = pollDao.activePolls();
		// this method when called will set all poll which are expired (>24hrs) status as active = false
		for(PollInfo poll : li) {
			LocalDateTime dateAndTime = poll.getCreationTime();
			LocalDateTime hours = dateAndTime.plusHours(24);
			if(hours.isAfter(LocalDateTime.now())) {
				// valid poll
			}else {
				//change status
				changeStatus(poll.getPollId(), false);
			}
		}
		
		
		// get all active polls with active = true
		List<PollInfo> l = pollDao.activePolls();
		List<PollInfoDto> activePolls = new ArrayList<>();
		
		for(PollInfo p : l) {
			activePolls.add(mapper.map(p, PollInfoDto.class));
		}
		return activePolls;
	}
	
	
	//this can give error - we are making fake poll
	@Override
	public List<PollOptionDto> getPollOptions(Integer pollId) {
		PollInfo poll = new PollInfo();
		poll.setPollId(pollId);
		
		List<PollOption> options = pollDao.getOptionsForPoll(poll);
		List<PollOptionDto> optionsDto = new ArrayList<>();
		for(PollOption o : options) {
			optionsDto.add(mapper.map(o,PollOptionDto.class));
		}
		return optionsDto;
	}
	
	// can be also used for update
	@Override
	public SelectionInfoDto saveVote(SelectionInfoDto choice) {
		SelectionInfo sel = mapper.map(choice, SelectionInfo.class);
//		System.out.println("in savevote , choice :"+choice);
//		System.out.println("in savevote , dto :" + sel);
		SelectionInfo s = pollDao.saveOption(sel);
		SelectionInfoDto selDto = mapper.map(s, SelectionInfoDto.class);
		return selDto;
	}
	
	@Override
	public List<PollStatistics> getStatisticsOfPoll(Integer pollId) {
		List<SelectionInfo> allSelections = pollDao.getSelectionByPollId(pollId);
		Integer totalVotes = allSelections.size();
		
		HashMap<Integer,List<String>> map = new HashMap<>();
		for(SelectionInfo s : allSelections) {
			Integer optionId = s.getOptionId();
			if(map.containsKey(optionId)) {
				List<String> voters = map.get(optionId);
				voters.add(s.getUserName());
				map.put(optionId, voters);
			}else {
				List<String> newVoter = new ArrayList<>();
				newVoter.add(s.getUserName());
				map.put(optionId, newVoter);
			}
		}
		
		List<PollStatistics> pollStats = new ArrayList<>();
		for(Integer optionId : map.keySet()) {
			PollStatistics ps = new PollStatistics();
			List<String> users = map.get(optionId);
			ps.setOptionName(pollDao.getOptionName(optionId));
			ps.setUserName(users);
			Integer userCount = users.size();
			ps.setOptionPercentage((float) (userCount*100/totalVotes));
			
			pollStats.add(ps);
		}
		return pollStats;
	}
	
	@Override
	public SelectionInfoDto updateVote(SelectionInfoDto choice) {
		// TODO Auto-generated method stub
		pollDao.updateOption(choice.getOptionId(), choice.getUserName());
		return choice;
	}
	
	@Override
	public void changeStatus(Integer pollId, boolean status) {
		pollDao.changeStatus(pollId, status);
	}
}
