package com.shivam.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer optionId;
	
	@ManyToOne
	@JoinColumn(name = "pollId")
	private PollInfo pollId;
	
	private String optionName;
}
