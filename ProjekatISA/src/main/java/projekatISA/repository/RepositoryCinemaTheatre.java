package projekatISA.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.CinemaTheatre;

@Repository
public interface RepositoryCinemaTheatre extends JpaRepository<CinemaTheatre,Long>{

	CinemaTheatre findOneById(Long id);

	

}
