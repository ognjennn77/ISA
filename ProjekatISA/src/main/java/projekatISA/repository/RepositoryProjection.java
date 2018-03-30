package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Projection;

@Repository
public interface RepositoryProjection extends JpaRepository<Projection, Long>{

	Projection findOneById(Long id);
}
