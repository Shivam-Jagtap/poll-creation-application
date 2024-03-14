package com.shivam.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollCreationDto {

	private String userName;
	private String pollName;
	private List<String> optionName;
}
