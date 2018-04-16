package projekatISA.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Announcement;
import projekatISA.domein.Bid;
import projekatISA.domein.User;
import projekatISA.repository.RepositoryAnnouncement;
import projekatISA.repository.RepositoryBid;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.BidServiceInterface;

@Service
public class BidService implements BidServiceInterface{

	@Autowired
	private RepositoryBid repositoryBid;
	
	@Autowired
	private RepositoryAnnouncement repositoryAnnouncement;
	
	@Autowired
	private RepositoryUser repositoryUser;
	
	
	/**
	 * Add bid on the announcement
	 * Checking whether if exists announcement
	 * Cheking whethre if announcement is approved
	 * 
	 */
	@Override
	public Bid addbid(Bid b) {
		Announcement announcement = repositoryAnnouncement.findByIdEquals(b.getAnnouncement().getId());
		
		if(!(announcement==null)) {
			if(announcement.isApproved()) {
				Date date = announcement.getDate();
				Date nowDate = new Date();
				if(nowDate.before(date)) {
					
					Bid bidd = repositoryBid.findByUser_idEqualsAndAnnouncement_idEquals(b.getUser().getId(), b.getAnnouncement().getId());   
					if(!(bidd==null)) {
						
						bidd.setOffered(b.getOffered());
						
						return repositoryBid.save(bidd);
						
					}
					
					return repositoryBid.save(b);
				}
				
			}
			
		}
		return null;
	}

	@Override
	public Bid getbid(Long id) {
		Bid bid = repositoryBid.findByIdEquals(id);
		if(!(bid==null)) {
			return bid;
		}
		return null;
	}

	@Override
	public Announcement findAnnouncementOfBid(Long id) {
		
		Bid bid = repositoryBid.findByIdEquals(id);

		if(!(bid==null)) {

			return bid.getAnnouncement();
			
		}
		return null;
	}

	@Override
	public Bid getBidOfUser(Long id, Long an) {
	
	
				Bid bid = repositoryBid.findByUser_idEqualsAndAnnouncement_idEquals(id, an);
				return bid;
	
		
		
	}
	
	
	
}
