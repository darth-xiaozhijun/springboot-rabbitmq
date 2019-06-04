package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {

	@RequestMapping(value = "/test.do",method = RequestMethod.GET)
	public String test(){
		return "Hello SpringBoot-RabbitMQ";
	}
}
