package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.FriendShip;
import projekatISA.domein.User;

public interface FriendShipServiceInterface {

	FriendShip addfriendship(Long idone,Long idtwo);
	
	List<FriendShip> getfriendrequest(Long idtwo);

	FriendShip acceptrequest(Long idf);
	
	FriendShip declinerequest(Long idf);
	
	List<User> getfriends(Long id);
}
