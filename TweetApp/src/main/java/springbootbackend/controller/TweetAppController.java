package springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootbackend.entity.RegisterEntity;
import springbootbackend.repository.TweetAppRepository;
import springbootbackend.request.RegisterUserRequest;
import springbootbackend.response.RegisterUserResponse;
import springbootbackend.services.TweetappService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetAppController {

	@Autowired
	TweetappService tweetappService;
	
	@Autowired
	TweetAppRepository tweetAppRepository;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest RegisterUserRequest) {
	
		return new ResponseEntity<>(tweetappService.createUser(RegisterUserRequest), HttpStatus.OK);
		
	}
	
	@GetMapping("/users/all/{id}")
	public RegisterUserResponse getAllTweet(@PathVariable int id) {
		
			return tweetappService.getUserDetails(id);
			
	}
	@GetMapping("/users/all")
	public List<RegisterEntity> getProducts() {
		return tweetAppRepository.findAll();
	}
}
