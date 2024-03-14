package com.shivam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.PollInfo;
import com.shivam.entity.PollOption;
import java.util.List;


public interface PollOptionsRepository extends JpaRepository<PollOption, Integer>{

	List<PollOption> findByPollId(PollInfo pollId);
//	List<PollOption> findByPollId(Integer pollId);
}
