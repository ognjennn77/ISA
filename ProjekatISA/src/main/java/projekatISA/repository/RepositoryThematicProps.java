package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.ThematicProps;

@Repository
public interface RepositoryThematicProps extends JpaRepository<ThematicProps, Long>{

	
	
	
}
