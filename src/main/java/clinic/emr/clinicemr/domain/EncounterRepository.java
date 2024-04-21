package clinic.emr.clinicemr.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EncounterRepository extends CrudRepository<Encounter, Long>{
    
    List<Encounter> findBypatient(Patient patient);
}
