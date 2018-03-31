package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;

@Repository
public interface RepositoryThematicProps extends JpaRepository<ThematicProps, Long>{

	ThematicProps findByIdEquals(Long id);
	
	
}
