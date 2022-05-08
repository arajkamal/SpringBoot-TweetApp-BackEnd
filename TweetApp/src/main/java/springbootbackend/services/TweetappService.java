package springbootbackend.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootbackend.entity.RegisterEntity;
import springbootbackend.repository.TweetAppRepository;
import springbootbackend.request.RegisterUserRequest;
import springbootbackend.response.RegisterUserResponse;

@Service
public class TweetappService {
	
	@Autowired
	TweetAppRepository tweetAppRepository;
	
	public RegisterUserResponse createUser(RegisterUserRequest registerUserRequest) {

		RegisterEntity registerEntity=new RegisterEntity();
		registerEntity.setFirstName(registerUserRequest.getFirstName());
		registerEntity.setLastName(registerUserRequest.getLastName());
		registerEntity.setGender(registerUserRequest.getGender());
		registerEntity.setDob(registerUserRequest.getDob());
		registerEntity.setEmail(registerUserRequest.getEmail());
		registerEntity.setPassword(registerUserRequest.getPassword());
		
		registerEntity = tweetAppRepository.save(registerEntity);

		return new RegisterUserResponse(registerEntity);
	}
	public RegisterUserResponse getUserDetails(int id){
		return new RegisterUserResponse(tweetAppRepository.findById(id).get());
	}
	
	

}
