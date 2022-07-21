
public class Doctor extends Person {
    protected String specialty;
    protected int medicalcode;

    public Doctor(String name,long nationalcode,String specialty,int medicalcode) {
        super(name, nationalcode);
        this.specialty = specialty;
        this.medicalcode = medicalcode;
    }


    public void setspecialty( String specialty) {
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setMedicalcode(int medicalcode) {
        this.medicalcode = medicalcode;
    }
    public int getMedicalcode() {
        return medicalcode;
    }

    public String tostring() {
        return super.name + ',' +super.nationalcode+','+specialty+','+medicalcode+';';
    }


    public void save() {
        File.save(this);
    }
    public void remove() {
        File.remove(this);
    }


}