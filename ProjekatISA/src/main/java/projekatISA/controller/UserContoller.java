package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.User;
import projekatISA.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/singInUser",method=RequestMethod.PUT)
	public ResponseEntity<User> singInUser(@RequestBody User user){
		System.out.println("aaaaaaaaaaaaaaaa");
		User user1 = userService.findUser(user.getEmail(), user.getPassword());
				
		return new ResponseEntity<>(user1, HttpStatus.OK);
	
	}
	
	

}
