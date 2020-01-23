/**
 * @author Umesh Bhujel <yoomesbhujel@gmail.com>
 * Since Sep 24, 2019
 */
package com.ishanitech.service;

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

import com.ishanitech.model.ResponseData;
import com.ishanitech.model.User;

@Service
public class RemoteApiCaller {
	@Autowired
	RestTemplate restTemplate;
	
	public List<User> getAllUsers() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(null, header);
		
		ResponseEntity<ResponseData> responseEntity = restTemplate.exchange("https://reqres.in/api/users/", HttpMethod.GET, entity, ResponseData.class);
		//List<User> users = (List<User>) responseEntity.getBody().getData();
		System.out.println(responseEntity.getBody().getData());
		return null;
	}
}
