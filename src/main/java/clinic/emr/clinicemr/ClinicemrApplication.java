package clinic.emr.clinicemr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import clinic.emr.clinicemr.domain.Patient;
import clinic.emr.clinicemr.domain.PatientRepository;

@SpringBootApplication
public class ClinicemrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicemrApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PatientRepository pRepository){

		return (args) -> {

			Patient p1 = new Patient(1231312, "Toan", "Nguyen", "11/9/1998");
			Patient p3 = new Patient(1231314, "David", "Ross", "11/11/1958");
			Patient p2 = new Patient(1231311, "John", "Doe", "11/9/2000");

			pRepository.save(p1);
			pRepository.save(p2);
			pRepository.save(p3);


		};

	}

}
