package com.shivam.dto;

import com.shivam.entity.PollInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PollOptionDto {

	private Integer optionId;
	private PollInfo pollId;
	private String optionName;
}
