package projekatISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.FriendShip;
import projekatISA.domein.User;
import projekatISA.repository.RepositoryFriendShip;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.FriendShipServiceInterface;

@Service
public class FriendShipeService implements FriendShipServiceInterface{

	@Autowired
	private RepositoryUser repositoryUser;
	
	@Autowired
	private RepositoryFriendShip repositoryFriendShip;
	
	
	
	@Override
	public FriendShip addfriendship(Long idone, Long idtwo) {
		
		User userone = repositoryUser.findByIdEquals(idone);
		
		if(!(userone==null)) {
			User usertwo = repositoryUser.findByIdEquals(idtwo);
			if(!(usertwo==null)) {
				
				FriendShip friendship = new FriendShip();
				friendship.setUserone(userone);
				friendship.setUsertwo(usertwo);
				friendship.setStatus("pending");
				repositoryFriendShip.save(friendship);
				return friendship;
				
			}
		}
		
		
		return null;
	}

	
	@Override
	public List<FriendShip> getfriendrequest(Long idtwo) {
		
		List<FriendShip> request = repositoryFriendShip.findByUsertwo_idEquals(idtwo);
		List<FriendShip> retList = new ArrayList<>();
		if(!(request==null)) {
			for(int i=0;i<request.size();i++) {

				if(request.get(i).getStatus().equals("pending")) {
					retList.add(request.get(i));
				}
				
				
			}
			return retList;
		}
		return null;
	}


	@Override
	public FriendShip acceptrequest(Long idf) {
		
		FriendShip frinedship = repositoryFriendShip.findByIdEquals(idf);
		
		if(!(frinedship==null)) {
			frinedship.setStatus("accepted");
			repositoryFriendShip.save(frinedship);
			return frinedship;
		}
		
		return null;
	}


	@Override
	public FriendShip declinerequest(Long idf) {
		
		FriendShip frinedship = repositoryFriendShip.findByIdEquals(idf);
		
		if(!(frinedship==null)) {
			frinedship.setStatus("declined");
			repositoryFriendShip.save(frinedship);
			return frinedship;
		}
		
		return null;

	}


	@Override
	public List<User> getfriends(Long id) {
		
		ArrayList<User> listUsers = new ArrayList<>();
		
		List<FriendShip> friendships1 = repositoryFriendShip.findByUserone_idEquals(id);

		if(!(friendships1==null)) {
			for(int i=0; i<friendships1.size();i++) {

				if(friendships1.get(i).getStatus().equals("accepted")) {
					User user = repositoryUser.findByIdEquals(friendships1.get(i).getUsertwo().getId());
					listUsers.add(user);
				}
			}
	
		}
		
		
		List<FriendShip> friendships2 = repositoryFriendShip.findByUsertwo_idEquals(id);

		if(!(friendships2==null)) {
			for(int i=0; i<friendships2.size();i++) {

				if(friendships2.get(i).getStatus().equals("accepted")) {
					User user = repositoryUser.findByIdEquals(friendships2.get(i).getUserone().getId());
					listUsers.add(user);
				}
			}
		
		}
		
		if(!(listUsers==null)) {
			return listUsers;
		}
		
		
		
	
		
		return null;
	}

	
}
