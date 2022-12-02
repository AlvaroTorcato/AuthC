package com.example.service;

import com.example.model.UserDetailsDTO;
import com.example.repository.JWTRepository;
import io.jsonwebtoken.Jwt;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Server {

	@Autowired
	JWTService service;

	@RabbitListener(queues = "${queue.name}")
	public UserDetailsDTO findProduct(String jwt) {
		System.out.println("Received request for " + jwt);
		UserDetailsDTO userDTO = service.searchForUser(jwt);

		System.out.println("Returned " + userDTO);

		return userDTO;
	}


}
