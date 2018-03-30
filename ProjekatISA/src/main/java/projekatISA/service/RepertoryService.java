package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Repertory;
import projekatISA.repository.RepositoryRepertory;
import projekatISA.serviceInterface.RepertoryServiceInterface;

@Service
public class RepertoryService implements RepertoryServiceInterface{
	
	
	@Autowired
	private RepositoryRepertory repositoryRepertory;

	@Override
	public Repertory findOne(Long id) {
		
		Repertory repertory = repositoryRepertory.findOneById(id);
		if(!(repertory==null))
			return repertory;	
		return null;
	}

	@Override
	public Repertory add(Repertory repertory) {
		
		return repositoryRepertory.save(repertory);
	}

	
	
}
