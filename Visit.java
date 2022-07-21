import java.io.*;
public class Visit implements Serializable {
    static int vid = 1;
    protected Doctor doctor;
    protected Patient patient;
    protected Drug drug;
    protected String data;
    protected int id;

    public Visit(Doctor doctor ,Patient patient ,Drug drug ,String data ) {
        this.doctor = doctor;
        this.patient = patient;
        this.drug = drug;
        this.data = data;
        this.id = vid;
        vid++;
    }
    
    public void setDocter(Doctor doctor) {
        this.doctor = doctor;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setDrug(Drug drug) {
        this.drug = drug;
    }
    public Drug getDrug() {
        return drug;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }

    public String tostring() {
        return "id is : "+id+" : "+  doctor.name + ','+patient.name+','+drug.name+','+data+';';
    }

    public void save() {
        File.save(this);
    }
    public void remove() {
        File.remove(this);
    }
}