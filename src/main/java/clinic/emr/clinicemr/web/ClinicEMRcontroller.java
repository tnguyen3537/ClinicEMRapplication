package clinic.emr.clinicemr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import clinic.emr.clinicemr.domain.PatientRepository;
import clinic.emr.clinicemr.domain.Encounter;
import clinic.emr.clinicemr.domain.EncounterRepository;
import clinic.emr.clinicemr.domain.Patient;


@Controller
public class ClinicEMRcontroller {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private EncounterRepository encounterRepository;

	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	// Show all patient
	// http://localhost:8080/patientlist
	@GetMapping(value={"/","/patientlist"})
	public String getInfo(Model model) {
		model.addAttribute("patients", patientRepository.findAll());
		return "patientList";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{id}")
	public String deletePatient(@PathVariable("id") Long patientId, Model model) {
		patientRepository.deleteById(patientId);
		return "redirect:../patientlist";
	}

	@GetMapping(value = "/edit/{id}")
	public String editPatient(@PathVariable("id") Long patientId, Model model) {
		model.addAttribute("patient", patientRepository.findById(patientId));
		return "editPatient";
	}

	@GetMapping(value = "/add")
	public String addPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "addPatient";
	}
	
	@PostMapping(value = "/save")
	public String save(Patient patient) {
		patientRepository.save(patient);
		return "redirect:patientlist";
	}

	//Encounter
	@GetMapping(value = "/encounter/{id}")
	public String getPatient(@PathVariable("id") Long patientId, Model model) {
		Patient patient = patientRepository.findById(patientId).get();
		model.addAttribute("patients", patient);
		model.addAttribute("encounters",encounterRepository.findBypatient(patient));
		return "encounterList";
	}

	@GetMapping(value = "/deleteEncounter/{id}")
	public String deleteEncounter(@PathVariable("id") Long contactId) {
		long patientId = encounterRepository.findById(contactId).get().getPatient().getId();
		encounterRepository.deleteById(contactId);
		return "redirect:../encounter/"+ patientId;
	}
	
	@GetMapping(value = "/updateEncounter/{contactId}")
	public String editEncounter(@PathVariable("contactId") Long contactId, Model model) {
		Patient patient = encounterRepository.findById(contactId).get().getPatient();
		model.addAttribute("patient", patient);
		model.addAttribute("encounter", encounterRepository.findById(contactId));
		return "editEncounter";
	}

	@GetMapping(value = "/addEncounter/{id}")
	public String addEncounter(@PathVariable("id") Long patientId, Model model) {
		Patient patient = patientRepository.findById(patientId).get();
		model.addAttribute("patients", patient);
		model.addAttribute("encounter", new Encounter(patient));
		return "addEncounter";
	}


	@PostMapping(value = "/saveEncounter/{id}")
	public String addEncounter(@PathVariable("id") Long patientId, Encounter encounter) {
		encounterRepository.save(encounter);
		return "redirect:../encounter/"+ patientId;
	}

}
