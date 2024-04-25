package clinic.emr.clinicemr;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import clinic.emr.clinicemr.domain.Patient;
import clinic.emr.clinicemr.domain.PatientRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ClinicemrApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientTest {
    @Autowired
	private PatientRepository patientRepository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Patient> patients = patientRepository.findByfName("Toan");
        
        assertThat(patients).hasSize(1);
        assertThat(patients.get(0).getfName()).isEqualTo("Toan");
    }
    
    @Test
    public void createNewPatient() {
        LocalDate dob1= LocalDate.of(1997, 12, 9);
    	Patient p1 = new Patient(12313122, "Phuong", "Nguyen", dob1);
    	patientRepository.save(p1);
    	assertThat(p1.getId()).isNotNull();

    }    
    @Test
    public void deleteNewBook() {
        List<Patient> patients = patientRepository.findByfName("Toan");
        Patient patient = patients.get(0);
		patientRepository.delete(patient);
		List<Patient> newpatients = patientRepository.findByfName("Toan");
		assertThat(newpatients).hasSize(0);
     }





}
