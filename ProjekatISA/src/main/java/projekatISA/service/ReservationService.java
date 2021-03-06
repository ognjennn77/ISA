
package projekatISA.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import projekatISA.controller.UserContoller;
import projekatISA.domein.CinemaTheatre;
import projekatISA.domein.ProjectionDate;
import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.repository.RepositoryCinemaTheatre;
import projekatISA.repository.RepositoryReservation;
import projekatISA.repository.RepositorySeat;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.ReservationServiceInterface;

@Service
public class ReservationService implements ReservationServiceInterface{

	@Autowired
	private RepositoryReservation repositoryReservation;
	
	@Autowired
	private RepositorySeat repositorySeat;
	
	@Autowired
	private RepositoryUser repositoryUser;
	
	private RepositoryCinemaTheatre repositoryCinThe;
	
	private Logger logger = LoggerFactory.getLogger(UserContoller.class);
	
	@Autowired 
	private EmailService emailService;
	
	@Override
	public Reservation findOne(Long id) {
		Reservation reservation = repositoryReservation.findOneById(id);
		System.out.println(reservation.getProjectionterm().getTerm());
		     
		SimpleDateFormat sdfStopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.0");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 30);
		Date d = c.getTime();
		String newStopTime = sdfStopTime.format(d);
		System.out.println(d);
		
		if(d.before(reservation.getProjectionterm().getTerm())) {
			System.out.println("usoo");
		}
		
		return reservation;
	}

	@Override
	public List<Reservation> getAll() {
		List<Reservation> reservation = repositoryReservation.findAll();
		
		return reservation;
	}

	@Override
	public Reservation add(Reservation reservation) {
		
		try {
			emailService.sendEmailRes(reservation, reservation.getUser1());;				
		}catch(Exception e) {
			logger.info("Greska prilikom slanja emaila" + e.getMessage());
		}
		System.out.println("termin"+reservation.getProjectionterm().getTerm());
		return repositoryReservation.save(reservation);
	}

	@Override
	public List<Reservation> getReservation(Long id) {
		List<Reservation> reservation = repositoryReservation.findAll();
		List<Reservation> newres=new ArrayList<Reservation>();
		
		for(int i=0; i<reservation.size();i++) {
			if(reservation.get(i).getUser1().getId().equals(id)) {
				
				System.out.println("od rez vreme"+reservation.get(i).getProjectionterm().getTerm());
				Date date = new Date();
				System.out.println("tr vreme"+date);
				if(date.before(reservation.get(i).getProjectionterm().getTerm())) {
					System.out.println("jestee");
					newres.add(reservation.get(i));
				}
			}			
		}
		return newres;
	}

	@Override
	public Reservation deleteReser(Long id) {
		Reservation reser = repositoryReservation.findOneById(id);
		System.out.println("datum"+reser.getProjectionterm().getTerm());
		
		SimpleDateFormat sdfStopTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.0");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 30);
		Date d = c.getTime();
		String newStopTime = sdfStopTime.format(d);
		System.out.println(d);
		
		if(d.before(reser.getProjectionterm().getTerm())) {
			System.out.println("moze brisati");
			if(reser.getSeats().size()!=0) {
				for(int i=0; i<reser.getSeats().size();i++) {
					reser.getSeats().get(i).setReserved(false);
				}
			}
			if(!(reser==null)) {
				repositoryReservation.delete(reser);
				return reser;
			}
		}
		System.out.println("ne moze brisati");
		return null;
	}

	@Override
	public List<Reservation> getHistoryRes(Long id) {
		List<Reservation> reservation = repositoryReservation.findAll();
		List<Reservation> newres=new ArrayList<Reservation>();
		
		for(int i=0; i<reservation.size();i++) {
			if(reservation.get(i).getUser1().getId().equals(id)) {
				
				
				Date date = new Date();
				
				if(date.after(reservation.get(i).getProjectionterm().getTerm())) {
					
					for(int j=0; j< reservation.get(i).getSeats().size();j++) {
						
						reservation.get(i).getSeats().get(j).setReserved(false);
						
						repositorySeat.save(reservation.get(i).getSeats().get(j));
					}
					newres.add(reservation.get(i));
				}
			}			
		}
		return newres;
	}

	@Override
	public Reservation inviteFri(Long id, Long td) {
		Reservation reser = repositoryReservation.findOneById(id);
		User user = repositoryUser.findByIdEquals(td);
		System.out.println(reser.getSeats().size());
		if(reser.getSeats().size()>1) {
			
			try {
				emailService.sendInvite(reser,user);				
			}catch(Exception e) {
				logger.info("Greska prilikom slanja emaila" + e.getMessage());
			}	
			
		}
		return reser;
	}

	@Override
	public Reservation acceptInvite(Long id) {
		
		Reservation reser = repositoryReservation.findOneById(id);
		if(reser.getSeats().size()>1) {
			
			ArrayList<Seat> listaSed = new ArrayList();
			for(int i=0; i<reser.getSeats().size();i++) {
				listaSed.add(reser.getSeats().get(i));
			}
			System.out.println("aaaaaa"+listaSed.size());
			reser.getSeats().get(0).setReserved(false);
			
			System.out.println("sediste"+reser.getSeats().get(0).getId());
			repositorySeat.save(reser.getSeats().get(0));
			System.out.println("velicina liste"+listaSed.size());
			for(int j=0; j<listaSed.size();j++) {
				System.out.println("id"+listaSed.get(j).getId());
			}
			System.out.println("velicina reser"+reser.getSeats().size());
			reser.getSeats().remove(0);
			repositoryReservation.save(reser);
		}
		
		
		return reser;
	}

	@Override
	public Reservation sendEmailReser(Long id, Long td) {
		Reservation reser = repositoryReservation.findOneById(id);
		User user = repositoryUser.findByIdEquals(td);
		
		try {
			emailService.sendEmailRes(reser,user);				
		}catch(Exception e) {
			logger.info("Greska prilikom slanja emaila" + e.getMessage());
		}
		return reser;
	}

	

}

