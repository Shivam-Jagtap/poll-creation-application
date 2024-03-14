package com.shivam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.PollInfo;
import java.util.List;


public interface PollInfoRepository extends JpaRepository<PollInfo, Integer>{

	public List<PollInfo> findByUserName(String userName);
	
//	public List<PollInfo> findByActive(boolean active);
	
	List<PollInfo> findByActive(boolean active);
	
}
