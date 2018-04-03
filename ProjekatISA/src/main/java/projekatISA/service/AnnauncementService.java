package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Annauncement;
import projekatISA.repository.RepositoryAnnauncement;
import projekatISA.serviceInterface.AnnauncementInterface;

@Service
public class AnnauncementService implements AnnauncementInterface{

	
	@Autowired 
	private RepositoryAnnauncement repositoryAnnauncement;

	@Override
	public Annauncement addAnn(Annauncement an) {
		an.setFormatOnDateAndDate(an.getStringdate());
		return repositoryAnnauncement.save(an);
	}

	@Override
	public Annauncement findAnnauncement(Long id) {
		Annauncement an = repositoryAnnauncement.findByIdEquals(id);
		if(!(an==null)) {
			return an;
		}
		return null;
	}
	
}