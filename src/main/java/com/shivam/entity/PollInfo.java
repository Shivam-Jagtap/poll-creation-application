package com.shivam.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pollId;
	
	private String userName;
	private String pollName;
    private LocalDateTime creationTime;
    private boolean isActive;
  
}
