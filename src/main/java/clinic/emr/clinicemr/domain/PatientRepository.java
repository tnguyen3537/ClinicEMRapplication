package clinic.emr.clinicemr.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository <Patient,Long>{
    List<Patient> findByfName(String fName);
}
