package clinic.emr.clinicemr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import clinic.emr.clinicemr.domain.PatientRepository;
import clinic.emr.clinicemr.domain.Patient;

@Controller
public class ClinicEMRcontroller {
	@Autowired
	private PatientRepository repository;

	// Show all patient
	// http://localhost:8080/patientlist
	@GetMapping(value={"/","/patientlist"})
	public String getInfo(Model model) {
		model.addAttribute("patients", repository.findAll());
		return "patientList";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long patientId, Model model) {
		repository.deleteById(patientId);
		return "redirect:../patientlist";
	}

	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long patientId, Model model) {
		model.addAttribute("patient", repository.findById(patientId));
		return "editpatient";
	}

	@GetMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("patient", new Patient());
		return "addpatient";
	}
	
	@PostMapping(value = "/save")
	public String save(Patient patient) {
		repository.save(patient);
		return "redirect:patientlist";
	}

}
