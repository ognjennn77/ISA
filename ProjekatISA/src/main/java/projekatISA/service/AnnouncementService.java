package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Announcement;
import projekatISA.domein.Bid;
import projekatISA.repository.RepositoryAnnouncement;
import projekatISA.serviceInterface.AnnouncementServiceInterface;

@Service
public class AnnouncementService implements AnnouncementServiceInterface{

	
	@Autowired 
	private RepositoryAnnouncement repositoryAnnouncement;

	@Override
	public Announcement addAnn(Announcement an) {
		return repositoryAnnouncement.save(an);
	}

	@Override
	public Announcement findAnnouncement(Long id) {
		Announcement an = repositoryAnnouncement.findByIdEquals(id);
		System.out.println(an.getDate());
		if(!(an==null)) {
			return an;
		}
		return null;
	}

	@Override
	public List<Bid> findBids(Long id) {
		
		Announcement an = repositoryAnnouncement.findByIdEquals(id);
		if(!(an==null)) {
			List<Bid> b = an.getBids();
			
			if(!(b==null)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public List<Announcement> getAllAnn() {
		List<Announcement> returnList = repositoryAnnouncement.findAll();
		System.out.println("bbbbbbbbbbbbbbb");
		if(!(returnList==null)) {
			System.out.println("cccccccccccc");
			return returnList;
		}
		return null;
	}

	@Override
	public List<Announcement> getAnnOfUser(Long id) {
		List<Announcement> annaouncements = repositoryAnnouncement.findByUser_idEquals(id);
		
		return annaouncements;
	}
	
}
