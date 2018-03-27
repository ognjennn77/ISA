package projekatISA.serviceInterface;

import org.springframework.mail.MailException;

import projekatISA.domein.User;

public interface EmailServiceInterface {

	void sendEmailToUser (User user) throws MailException, InterruptedException;
	
	
}
