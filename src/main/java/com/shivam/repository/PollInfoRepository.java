package com.shivam.repository;

import org.hibernate.sql.ast.tree.update.UpdateStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shivam.entity.PollInfo;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;


public interface PollInfoRepository extends JpaRepository<PollInfo, Integer>{

	public List<PollInfo> findByUserName(String userName);
	
//	public List<PollInfo> findByActive(boolean active);
	
	List<PollInfo> findByActive(boolean active);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE PollInfo p SET p.active = :status WHERE p.pollId = :pollId")
	public void changeActiveStatus(Integer pollId,boolean status);
	
}
