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
		System.out.println("1");
		email.setTo(user.getEmail());
		System.out.println("2");
		email.setFrom(env.getProperty("spring.mail.username"));
		System.out.println("3");
		email.setSubject("Potvrda registracije");
		System.out.println("4");
		email.setText("Mejl je poslat isi");
		System.out.println("5");
		javaMailSender.send(email);
		
		System.out.println("email poslat");
	}

	
	
	
	
}
