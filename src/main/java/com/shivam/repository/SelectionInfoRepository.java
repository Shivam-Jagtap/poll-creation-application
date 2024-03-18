package com.shivam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shivam.entity.SelectionInfo;

import jakarta.transaction.Transactional;

public interface SelectionInfoRepository extends JpaRepository<SelectionInfo, Integer>{

	public List<SelectionInfo> findByUserName(String userName);
	
	public List<SelectionInfo> findByPollId(Integer pollId);
	
	@Modifying
	@Transactional
	@Query("UPDATE SelectionInfo s SET s.optionId = :optionId WHERE s.userName = :userName")
	void updateVote(Integer optionId , String userName);
}
