package projekatISA.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.User;
import projekatISA.domeinDTO.UserDTO;
import projekatISA.service.EmailService;
import projekatISA.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserContoller {
	
	private Logger logger = LoggerFactory.getLogger(UserContoller.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private EmailService emailService;
	
	@RequestMapping(value="/logIn",method=RequestMethod.POST)
	public ResponseEntity<User> singInUser(@RequestBody UserDTO user){
		
		User user1 = userService.findUser(user.getEmail(), user.getCurrentPassword());
		
		if(user1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user1, HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.PUT)
	public ResponseEntity<User> registrionUser(@RequestBody UserDTO u){

		User user1 = userService.saveUser(u);
		if(!(user1==null)) {
			try {
				emailService.sendEmailToUser(user1);
				return new ResponseEntity<>(user1,HttpStatus.OK);
			}catch(Exception e) {
				logger.info("Greska prilikom slanja emaila" + e.getMessage());
			}	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/acceptRegist/{id}")
	public String acceptingRegistration(@PathVariable Long id) {
		User user1 = userService.acceptRegistration(id);
		if(!(user1==null)) {
			return "success";
		}
		return "unsuccess";
	}
	
	@RequestMapping(value="/editUser")
	public ResponseEntity<User> editUser(@RequestBody UserDTO user){
		User u = userService.findUserEdit(user);
		if(u==null) {
			return null;
		}
		
		return new ResponseEntity<>(u,HttpStatus.OK);				
	}
	
	@RequestMapping(value="/editPassword")
	public ResponseEntity<User> editPassword(@RequestBody UserDTO user){
		
		User u= userService.findUserPassword(user);
		if(u==null) {
			return null;
		}
		
		
		return new ResponseEntity<>(u,HttpStatus.OK);

	}
}
