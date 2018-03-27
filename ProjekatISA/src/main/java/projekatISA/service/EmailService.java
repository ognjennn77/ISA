package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import projekatISA.domein.User;
import projekatISA.serviceInterface.EmailServiceInterface;

@Service
public class EmailService implements EmailServiceInterface {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	
	@Override
	public void sendEmailToUser(User user) throws MailException, InterruptedException {
		
		System.out.println("Slanje emaila...");
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setFrom(env.getProperty("spring.mail.username"));
		email.setSubject("Potvrda registracije");
		String text = "http://localhost:4567/api/users/sendEmail";
		email.setText(text);
		
		javaMailSender.send(email);
		
		System.out.println("email poslat");
	}

	
	
	
	
}
