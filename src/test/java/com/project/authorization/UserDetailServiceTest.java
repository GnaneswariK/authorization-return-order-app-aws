package com.project.authorization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.authorization.entity.User;
import com.project.authorization.repository.UserRepository;
import com.project.authorization.service.UserDetailService;

@SpringBootTest
public class UserDetailServiceTest {
	
	@Autowired
	private UserDetailService service;
	
	@Autowired
    private UserRepository repository;
	
	@Test
	public void getUserTest() {
		User userDetail = repository.findByUsername("user1");
		String user=userDetail.getUsername();
		assertEquals("user1",user);
	}

}
