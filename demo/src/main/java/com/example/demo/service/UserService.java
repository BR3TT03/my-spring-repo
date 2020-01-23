package com.example.demo.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ResponseData;
import com.example.demo.model.UserData;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	public List<UserData> getAllUsers() {
		HttpHeaders headers = new HttpHeaders();	
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> httpEntity = new HttpEntity<String>(null,headers);
		ResponseEntity<ResponseData> entity = restTemplate.exchange(
"https://reqres.in/api/users/",HttpMethod.GET,httpEntity, ResponseData.class);
		return (List<UserData>) (entity.getBody().getData());
	}

}
