package projekatISA.serviceInterface;

import projekatISA.domein.Announcement;
import projekatISA.domein.Bid;

public interface BidServiceInterface {

	
	Bid addbid(Bid b);
	
	Bid getbid(Long id);
	
	Announcement findAnnouncementOfBid(Long id);
}
