package com.shivam.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollDetailDto {

	private Integer pollId;
	private String pollName;
    private boolean active;
}
