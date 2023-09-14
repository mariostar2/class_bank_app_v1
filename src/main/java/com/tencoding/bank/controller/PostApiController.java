package com.tencoding.bank.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {
	@PostMapping("/post1")
	public void post1(@RequestBody Map<String, Object>requestData) {
		requestData.entrySet().forEach(entry ->{
			System.out.println("key : " + entry.getKey());
			System.out.println("key:" + entry.getValue());
		});
	}
}
