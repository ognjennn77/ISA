package projekatISA.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import projekatISA.domein.Reservation;
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
		String text = "http://localhost:4567/user/acceptRegist/"+user.getId();
		email.setText(text);
		
		javaMailSender.send(email);
		
		System.out.println("email poslat");
	}
	
	@Override
	public void sendInvite(Reservation reser, User user) throws MailException, InterruptedException {
		
		System.out.println("aloo glavonja");
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setFrom(env.getProperty("spring.mail.username"));
		System.out.println(reser.getUser1().getEmail());
		email.setSubject("Poziv na predstavu/film");
		String text = "Poziva vas korisnik "+reser.getUser1().getName()+" "+reser.getUser1().getSurname() +" na predstavu/film\n"
				+ "Ukoliko ne zelite da dodjete na predstavu/film, otkazite dolazak na sledecem linku\n"
				+ "http://localhost:4567/reservation/NOOOacceptInvite/"+reser.getId();
				
		email.setText(text);
		
		javaMailSender.send(email);
		
		
	}

	@Override
	public void sendEmailRes(Reservation reser, User user) throws MailException, InterruptedException {

		System.out.println("aloo bree");
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setFrom(env.getProperty("spring.mail.username"));
		System.out.println(reser.getProjectionterm().getTerm());
		email.setSubject("Rezervacija predstave/filma");
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = reser.getProjectionterm().getTerm();
		String datum = dateFormat.format(date);
		String sedista = new String();
		for(int i=0; i<reser.getSeats().size();i++) {
			sedista=sedista+reser.getSeats().get(i).getOrdinal()+" ";
		};
	
		String text = "Rezervisali ste predstavu/film "+reser.getProjectionA()+", "+reser.getDateA()+" u "+datum+"\n"
				+"Brojevi sedista koje ste rezervisali su: "+sedista;
				
			
		email.setText(text);
		
		javaMailSender.send(email);
		
	}

	
	
	
	
}
