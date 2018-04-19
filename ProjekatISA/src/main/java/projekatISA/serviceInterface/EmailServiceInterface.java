package projekatISA.serviceInterface;

import org.springframework.mail.MailException;

import projekatISA.domein.Reservation;
import projekatISA.domein.User;

public interface EmailServiceInterface {

	void sendEmailToUser (User user) throws MailException, InterruptedException;

	void sendInvite(Reservation reser) throws MailException, InterruptedException;
	
	
}
