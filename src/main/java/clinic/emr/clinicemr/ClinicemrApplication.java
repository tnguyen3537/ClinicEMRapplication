package clinic.emr.clinicemr;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import clinic.emr.clinicemr.domain.AppUser;
import clinic.emr.clinicemr.domain.AppUserRepository;
import clinic.emr.clinicemr.domain.EncounterRepository;
import clinic.emr.clinicemr.domain.Patient;
import clinic.emr.clinicemr.domain.PatientRepository;

@SpringBootApplication
public class ClinicemrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicemrApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PatientRepository pRepository, EncounterRepository eRepository, AppUserRepository urepository){

		return (args) -> {

			LocalDate dob1= LocalDate.of(1998, 11, 9);
			LocalDate dob2= LocalDate.of(1998, 10, 10);
			LocalDate dob3= LocalDate.of(1965, 5, 5);

			Patient p1 = new Patient(1231312, "Toan", "Nguyen", dob1);
			Patient p3 = new Patient(1231314, "David", "Ross", dob2);
			Patient p2 = new Patient(1231311, "John", "Doe", dob3);

			pRepository.save(p1);
			pRepository.save(p2);
			pRepository.save(p3);

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	}

}
