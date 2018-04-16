package projekatISA.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Notification;
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.domeinDTO.UserDTO;
import projekatISA.service.EmailService;
import projekatISA.service.UserService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/user")
public class UserContoller {
	
	private Logger logger = LoggerFactory.getLogger(UserContoller.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private EmailService emailService;
	
	/**
	 * SingIn user
	 * @param user
	 * @return user
	 */
	@RequestMapping(value="/logIn",method=RequestMethod.POST)
	public ResponseEntity<UserDTO> singInUser(@RequestBody UserDTO user){
		
		UserDTO user1 = userService.findUser(user.getEmail(), user.getPassword());
		
		if(user1==null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user1, HttpStatus.OK);
	
	}
	
	/**
	 * Registration user
	 * @param user
	 * @return user
	 */
	@RequestMapping(value="/registration",method=RequestMethod.PUT)
	public ResponseEntity<User> registrionUser(@RequestBody UserDTO u){
		System.out.println("dosao u metodu");
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

	/**
	 * The user accepting the registration
	 * @param id of the user
	 * @return
	 */
	@RequestMapping(value="/acceptRegist/{id}")
	public String acceptingRegistration(@PathVariable Long id) {
		User user1 = userService.acceptRegistration(id);
		if(!(user1==null)) {
			return "success";
		}
		return "unsuccess";
	}
	
	/**
	 * Edit user
	 * @param user
	 * @return user
	 */
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public ResponseEntity<User> editUser(@RequestBody UserDTO user){
		User u = userService.findUserEdit(user);
		if(u==null) {
			return null;
		}
		
		return new ResponseEntity<>(u,HttpStatus.OK);				
	}
	
	/**
	 * The user change his password
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/editPassword",method=RequestMethod.POST)
	public ResponseEntity<User> editPassword(@RequestBody UserDTO user){
		System.out.println("dosao u edit pass");
		User u= userService.findUserPassword(user);
		if(u==null) {
			return null;
		}
		
		
		return new ResponseEntity<>(u,HttpStatus.OK);

	}
	
	/**
	 *  Return props of the user
	 * @param id of the user
	 * @return thematic props
	 */
	@RequestMapping(value="/getThematicProps/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<ThematicProps>> getThematicProps(@PathVariable Long id){
		
		List<ThematicProps> th = userService.findThematicProps(id);
		if(!(th==null)) {
			return new ResponseEntity<>(th,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	/**
	 *  Return notification of the user
	 * @param id of the user
	 * @return notification
	 */
	@RequestMapping(value="/getNotification/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Notification>> getNotification(@PathVariable Long id){
		
		List<Notification> notifi = userService.findNotification(id);
		if(!(notifi==null)) {
			return new ResponseEntity<>(notifi,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
}
