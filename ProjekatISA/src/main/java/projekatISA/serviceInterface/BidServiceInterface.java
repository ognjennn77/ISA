package projekatISA.serviceInterface;

import projekatISA.domein.Bid;

public interface BidServiceInterface {

	
	Bid addbid(Bid b);
	
	Bid getbid(Long id);
}
