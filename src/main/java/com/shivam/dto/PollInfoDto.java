package com.shivam.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PollInfoDto {

	private Integer pollId;
	private String userName;
	private String pollName;
    private LocalDateTime creationTime;
    private boolean active;
}
