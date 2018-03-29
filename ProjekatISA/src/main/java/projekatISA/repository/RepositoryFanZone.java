package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.FanZone;

@Repository
public interface RepositoryFanZone extends JpaRepository<FanZone, Long> {

}
