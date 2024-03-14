package com.shivam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.SelectionInfo;

public interface SelectionInfoRepository extends JpaRepository<SelectionInfo, Integer>{

	public List<SelectionInfo> findByUserName(String userName);
	
	public List<SelectionInfo> findByPollId(Integer pollId);
}
