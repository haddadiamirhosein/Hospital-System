import java.io.*;
public class Message implements Serializable {
    static int mid = 1;
    protected Doctor doctor;
    protected Patient patient;
    protected String subject;
    protected String data;
    protected Visit visit;
    protected int id;

    public Message(Doctor doctor,Patient patient,String subject,String data,Visit visit) {
        this.doctor = doctor;
        this.patient = patient;
        this.subject = subject;
        this.data = data;
        this.visit = visit;
        this.id = mid;
        mid++;
    }


    public void setDoctor(Doctor doctor) {
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
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    public Visit getVisit() {
        return visit;
    }

    public String tostring() {return "id is : "+id+ " : " + doctor.name+","+patient.name;}
    
    public void save() {
        File.save(this);
    }
    public void remove() {
        File.remove(this);
    }

    



    
}