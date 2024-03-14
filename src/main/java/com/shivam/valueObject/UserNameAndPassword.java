package com.shivam.valueObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserNameAndPassword {

	private String userName;
	private String password;
}
