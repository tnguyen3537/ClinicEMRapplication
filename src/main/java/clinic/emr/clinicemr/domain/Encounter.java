package clinic.emr.clinicemr.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;
    private int heartRate, respiratoryRate, spO2, temp;
    private String rfv, bloodPressure;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate contactDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    public Encounter(){
    };

    public Encounter(Patient patient){
        this.patient = patient;
    };

    public Encounter(int heartRate, int respiratoryRate, int spO2, int temp, String rfv, String bloodPressure, LocalDate contactDate, Patient patient) {
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.spO2 = spO2;
        this.temp = temp;
        this.rfv = rfv;
        this.bloodPressure = bloodPressure;
        this.contactDate = contactDate;
        this.patient = patient;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getSpO2() {
        return spO2;
    }

    public void setSpO2(int spO2) {
        this.spO2 = spO2;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getRfv() {
        return rfv;
    }

    public void setRfv(String rfv) {
        this.rfv = rfv;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }  
    
    public LocalDate getContactDate() {
        return contactDate;
    }

    public void setContactDate(LocalDate contactDate) {
        this.contactDate = contactDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Encounter [contactId=" + contactId + ", heartRate=" + heartRate + ", respiratoryRate=" + respiratoryRate
                + ", spO2=" + spO2 + ", temp=" + temp + ", rfv=" + rfv + ", bloodPressure=" + bloodPressure + "]";
    }

}
