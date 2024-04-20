package clinic.emr.clinicemr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int mrn;
    private String fName, lName, dateofBirth;

    public Patient() {
	}

    public Patient(int mrn, String fName, String lName, String dateofBirth) {
        this.mrn = mrn;
        this.fName = fName;
        this.lName = lName;
        this.dateofBirth = dateofBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMrn() {
        return mrn;
    }

    public void setMrn(int mrn) {
        this.mrn = mrn;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", mrn=" + mrn + ", fName=" + fName + ", lName=" + lName + ", dateofBirth="
                + dateofBirth + "]";
    }

}
