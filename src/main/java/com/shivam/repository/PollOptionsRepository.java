package com.shivam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.PollOption;

public interface PollOptionsRepository extends JpaRepository<PollOption, Integer>{

}