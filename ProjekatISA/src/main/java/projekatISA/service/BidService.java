package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Bid;
import projekatISA.repository.RepositoryBid;
import projekatISA.serviceInterface.BidServiceInterface;

@Service
public class BidService implements BidServiceInterface{

	@Autowired
	private RepositoryBid repositoryBid;

	@Override
	public Bid addbid(Bid b) {
		
		return repositoryBid.save(b);
	}

	@Override
	public Bid getbid(Long id) {
		Bid bid = repositoryBid.findByIdEquals(id);
		if(!(bid==null)) {
			return bid;
		}
		return null;
	}
	
	
	
}
