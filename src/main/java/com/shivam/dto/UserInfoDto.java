package com.shivam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDto {

	private String userName;

	private String password;

	private String email;
}
