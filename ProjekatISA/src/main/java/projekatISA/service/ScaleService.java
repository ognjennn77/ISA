package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Scale;
import projekatISA.repository.RepositoryScale;
import projekatISA.serviceInterface.ScaleServiceInterface;

@Service
public class ScaleService implements ScaleServiceInterface {

	
	@Autowired
	private RepositoryScale repositoryScale;

	@Override
	public Scale addscale(Scale s) {
		
		Scale sc = repositoryScale.findByIdEquals(s.getId());
		
		if(sc==null) {
			repositoryScale.save(s);
			return s;
		}
		return null;
	}
	
	
	
	
}
