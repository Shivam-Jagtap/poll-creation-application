package com.shivam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SelectionInfoDto {

	private String userName;
	private Integer optionId;
	private Integer pollId;
}
