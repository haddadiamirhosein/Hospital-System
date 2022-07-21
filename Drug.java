import java.io.*;
import java.io.Serializable;
public class Drug implements Serializable {
    static int did = 1;
    protected String name;
    protected String company;
    protected String illness;
    protected String makedate;
    protected String expiredate;
    protected String description;
    protected int id;

    public Drug(String name,String company,String illness,String makedate,String expiredate,String description){
        this.name = name;
        this.company = company;
        this.illness = illness;
        this.makedate = makedate;
        this.expiredate = expiredate;
        this.description = description;
        this.id = did;
        did++;
    }

//    public Drug(String name,String expiredate,String company) {
//        this.name = name;
//        this.expiredate = expiredate;
//        this.company = company;
//    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompany() {
        return company;
    }
    public void setIllness(String illness) {
        this.illness = illness;
    }
    public String getIllness() {
        return illness;
    }
    public void setMakedate(String makedate) {
        this.makedate = makedate;
    }
    public String getMakedate() {
        return makedate;
    }
    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }
    public String getExpiredate() {
        return expiredate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public String tostring() {
        return "id is : "+ id + " : "+ name + "," + company + "," + expiredate+";";
    }

    public void save() {
        File.save(this);
    }
    public void remove() {
        File.remove(this);
    }
}