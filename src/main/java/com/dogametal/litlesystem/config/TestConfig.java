package com.dogametal.litlesystem.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dogametal.litlesystem.entities.Orders;
import com.dogametal.litlesystem.entities.User;
import com.dogametal.litlesystem.repositories.OrderRepository;
import com.dogametal.litlesystem.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Here you put action to run
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// Here you put action to run orders		
		Orders o1 = new Orders(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Orders o2 = new Orders(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Orders o3 = new Orders(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 

		// Here you save data on datababase
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	} 
	
}
