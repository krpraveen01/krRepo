package com.krpk.springboot.SpringEurekaClient2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/svc2")
public class ClientServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path ="/getSvc2/details/{name}")
	public List<String> getDetails(@PathVariable("name") String name) {
		return restTemplate.getForObject("http://localhost:8080/rest/getUser/"+name, List.class);
	}
	
	@GetMapping(path ="/getSvc2/userdetails/{name}")
	public List<UserInfo> getUserDetails(@PathVariable("name") String name) {
		return restTemplate.getForObject("http://SPRING-EUREKA-CLIENT/svc/getSvc/"+name, List.class);
	}
}
