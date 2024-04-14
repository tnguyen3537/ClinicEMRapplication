package clinic.emr.clinicemr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ClinicEMRcontroller {

	@GetMapping("/patient")

	public String welcome(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {

		model.addAttribute("age", age);
		model.addAttribute("name", name);

		return "patientList";

	}

}
