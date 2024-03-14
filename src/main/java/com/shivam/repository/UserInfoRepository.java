package com.shivam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
