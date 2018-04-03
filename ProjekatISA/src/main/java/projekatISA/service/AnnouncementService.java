package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Announcement;
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
	
}
