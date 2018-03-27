package projekatISA.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.User;
import projekatISA.service.EmailService;
import projekatISA.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserContoller {
	
	private Logger logger = LoggerFactory.getLogger(UserContoller.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private EmailService emailService;
	
	@RequestMapping(value="/logIn",method=RequestMethod.POST)
	public ResponseEntity<User> singInUser(@RequestBody User user){
		User user1 = userService.findUser(user.getEmail(), user.getPassword());
		if(user1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user1, HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.PUT)
	public ResponseEntity<User> registrionUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return new ResponseEntity<>(user1,HttpStatus.OK);
		
	}

	@RequestMapping(value="/sendEmail")
	public String sendEmail(@RequestBody User user) {
		
		try {
			emailService.sendEmailToUser(user);
			System.out.println("try");
		}
		catch(Exception e){
			System.out.println("catch");
			logger.info("Greska prilikom slanja emaila" + e.getMessage());
		}
		
		return "success";
	} 
	
	
	
}
