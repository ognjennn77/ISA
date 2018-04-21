package projekatISA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.FriendShip;

@Repository
public interface RepositoryFriendShip extends JpaRepository<FriendShip, Long> {

	FriendShip findByIdEquals(Long id);
	
	List<FriendShip> findByUserone_idEquals(Long id);
	
	List<FriendShip> findByUsertwo_idEquals(Long id);
	
}
