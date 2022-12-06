package com.sprintboot.krpk.SpringBootEureka.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/svc")
public class ServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private AtomicInteger id = new AtomicInteger(0);
	private AtomicInteger ph = new AtomicInteger(12345);
	
	@GetMapping(path="/getSvc/{name}")
	public List<UserInfo> getUserSvc(@PathVariable("name") String name){
		
		ResponseEntity<List<String>> response = restTemplate.exchange("http://localhost:8080/rest/getUser/"+name, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
		});
		List<String> userNames = response.getBody();
		System.out.println("Stream moongo op:::"+userNames.stream());
		return userNames.stream().map(user -> getUseInfo(user)).collect(Collectors.toList());
		System.out.println("Test 1");
		//return restTemplate.getForObject("http://localhost:8080/rest/getUser/"+name, List.class);

	}
private UserInfo getUseInfo(String userName) {
	UserInfo userInfo = new UserInfo();
	userInfo.setUserId(id.getAndIncrement());
	userInfo.setGender("M");
	userInfo.setPhNUm("845"+ph.incrementAndGet());
	userInfo.setName(userName);
	return userInfo;
}

}
