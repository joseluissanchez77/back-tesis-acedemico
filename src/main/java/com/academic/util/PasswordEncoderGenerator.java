package com.academic.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.academic.ApiTesisAcademicoV1Application;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {

		//$2a$10$q1vXQV6P9/Qit2KenXj1KuwZxgBXmDAzByAuj2PydyAqsMJ4/YBs6
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("password"));
	}

}
