import java.io.*;
import java.io.Serializable;
public class Person implements Serializable {
    protected String name;
    protected long nationalcode;

    public Person(String name,long nationalcode) {
        this.name = name;
        this.nationalcode = nationalcode;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setNationalcode(long nationalcode) {
        this.nationalcode = nationalcode;
    }
    public long getNationalcode() {
        return nationalcode;
    }

//    public void save() {
//        File.save(this);
//    }
//    public void remove() {
//        File.remove(this);
//    }

}