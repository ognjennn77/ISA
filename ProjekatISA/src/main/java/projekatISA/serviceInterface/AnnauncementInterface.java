package projekatISA.serviceInterface;

import projekatISA.domein.Annauncement;

public interface AnnauncementInterface {

	Annauncement addAnn(Annauncement an);
	
	Annauncement findAnnauncement(Long id);
}
