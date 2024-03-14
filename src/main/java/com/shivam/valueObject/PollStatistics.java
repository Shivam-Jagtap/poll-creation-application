package com.shivam.valueObject;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PollStatistics {
	private String optionName;
	private Float optionPercentage;
	private List<String> userName;

}
