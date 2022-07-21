public class Patient extends Person {
    protected String illness;

    public Patient(String name,long nationalcode,String illness) {
        super(name, nationalcode);
        this.illness = illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
    public String getIllness() {
        return illness;
    }

    public String tostring() {
        return super.name+','+super.nationalcode+','+illness+';';
    }


    public void save() {
        File.save(this);
    }
    public void remove() {
        File.remove(this);
    }
}