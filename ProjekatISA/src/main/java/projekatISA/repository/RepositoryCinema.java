package projekatISA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Cinema;

@Repository
public interface RepositoryCinema extends JpaRepository<Cinema,Long>{

	Cinema findOneById(Long id);

	

}
