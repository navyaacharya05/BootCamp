package bootcamp.basic.react.DlitheJavaBootCamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootcamp.basic.react.DlitheJavaBootCamp.entity.Corporate;

@Repository
public interface CorporateRepository extends JpaRepository<Corporate, String>
{
	
}
