package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.model.Pozoriste;

@Repository
public interface PozoristeInterfejs extends JpaRepository<Pozoriste,Long>{

	
}
