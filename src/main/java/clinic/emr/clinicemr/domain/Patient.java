package clinic.emr.clinicemr.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int mrn;
    private String fName, lName;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateofBirth;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Encounter> encounters;

    public Patient() {
    }

    public Patient(int mrn, String fName, String lName, LocalDate dateofBirth) {
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

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public List<Encounter> getEncounter() {
        return encounters;
    }

    public void setEncounter(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", mrn=" + mrn + ", fName=" + fName + ", lName=" + lName + ", dateofBirth="
                + dateofBirth + "]";
    }

}
