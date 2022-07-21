import java.util.ArrayList;
import java.io.*;

public class File {

    public static String doctorpath  = "F:\\p.f\\doctors.txt";
    public static String patientpath = "F:\\p.f\\patients.txt";
    public static String drugpath    = "F:\\p.f\\drugs.txt";
    public static String messagepath = "F:\\p.f\\messags.txt";
    public static String visitpath   = "F:\\p.f\\visits.txt";
    public static ArrayList<Doctor> doctors   = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Drug> drugs       = new ArrayList<>();
    public static ArrayList<Visit> visits     = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();
    public static ArrayList<Person> people    = new ArrayList<>();


      //++++++++++++++++++++++++++++++++++++++ Rewrite objects +++++++++++++++++++++++++++++


    public static void writedoctor() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(doctorpath))) {

            for(Doctor d : File.doctors)
                out.writeObject(d);

            out.close();
            System.out.println("Saved...");
        }
        catch (IOException ex) {
            System.out.println("cant save");
        }
    }

    public static void writepatient() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(patientpath))) {

            for(Patient p : File.patients)
                out.writeObject(p);

            out.close();
            System.out.println("Saved...");
        }
        catch (IOException ex) {
            System.out.println("cant save");
        }
    }

    public static void writedrug() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(drugpath))) {

            for(Drug dru : File.drugs)
                out.writeObject(dru);

            out.close();
            System.out.println("Saved...");
        }
        catch (IOException ex) {
            System.out.println("cant save");
        }
    }

    public static void writevisit() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(visitpath))) {

            for(Visit v : File.visits)
                out.writeObject(v);


            out.close();
            System.out.println("Saved...");

        }
        catch (IOException ex) {
            System.out.println("cant save");
        }
    }

    public static void writemessaage() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(messagepath))) {

            for(Message m : File.messages)
                out.writeObject(m);

            out.close();
            System.out.println("Saved...");
        }
        catch (IOException ex) {
            System.out.println("cant save");
        }
    }


    //++++++++++++++++++++++++++++++++++++++++++++ saving ++++++++++++++++++++++++++++++++++



    public static void save(Doctor doctor) {
        doctors.add(doctor);
        File.writedoctor();
    }

    public static void save(Patient patient) {
        patients.add(patient);
        File.writepatient();
    }

    public static void save(Drug drug) {
        drugs.add(drug);
        File.writedrug();
    }

    public static void save(Visit visit) {
        visits.add(visit);
        File.writevisit();
    }

    public static void save(Message message) {
        messages.add(message);
        File.writemessaage();
    }


    //++++++++++++++++++++++++++++++++++ removing +++++++++++++++++++++++++++++++++

    public static void remove(Doctor doctor) {

        for (int i = 0 ;i<messages.size();i++) {
             Message m = messages.get(i);
            if (m.doctor.nationalcode == doctor.nationalcode) {
                messages.remove(m);
                i-=1;
            }
        }

        for (int i = 0;i<visits.size();i++) {
            Visit v = visits.get(i);
            if (v.doctor.nationalcode == doctor.nationalcode) {
                visits.remove(v);
                i-=1;
            }
        }

        doctors.remove(doctor);
        File.writedoctor();
        File.writevisit();
        File.writemessaage();
        System.out.println("doctor and his message and visits removed...");
    }

    public static void remove(Patient patient) {

        for (int i = 0 ;i<messages.size();i++) {
            Message m = messages.get(i);
            if (m.patient.nationalcode == patient.nationalcode) {
                messages.remove(m);
                i-=1;
            }
        }

        for(int i = 0; i<visits.size() ; i++) {
            Visit v = visits.get(i);
            if (v.patient.nationalcode == patient.nationalcode) {
                visits.remove(v);
                i-=1;
            }
        }

        patients.remove(patient);
        File.writepatient();
        File.writevisit();
        File.writemessaage();
        System.out.println("patient and his visit and message removed...");
    }

    public static void remove(Drug drug) {
        for(int i = 0;i<visits.size();i++){
            Visit v = visits.get(i);
            if(v.drug.id == drug.id) {
                v.remove();
                i-=1;
            }

        }

        drugs.remove(drug);
        File.writedrug();
        System.out.println("drug removed...");
    }

    public static void remove(Visit visit) {
        for(int i = 0;i<messages.size();i++){
            Message me = messages.get(i);
            if(me.visit.id == visit.id) {
                me.remove();
                i-=1;
            }

        }

        visits.remove(visit);

        File.writevisit();

        System.out.println("visit removed...");
    }

    public static void remove(Message message) {
        messages.remove(message);
        File.writemessaage();
        System.out.println("message removed...");
    }


    //++++++++++++++++++++++++++++++++++++++++ Load objects ++++++++++++++++++++++++++++++++++++++++


    public static void loaddoctor() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(doctorpath))) {
            while (true) {
                Doctor d = (Doctor)in.readObject();
                doctors.add(d);
            }

        }
        catch (EOFException eof) {
            System.out.println("Load of doctors completed :)");
        }
        catch (IOException e) {

        }
        catch (ClassNotFoundException e) {
            System.out.println();
        }
    }

    public static void loadpatient() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(patientpath))) {
            while (true) {
                Patient p = (Patient)in.readObject();
                patients.add(p);
            }
        }
        catch (EOFException eof) {
            System.out.println("Load of patients completed :)");
        }
        catch (IOException e) {

        }
        catch (ClassNotFoundException e) {
            System.out.println();
        }
    }

    public static void loaddrug() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(drugpath))) {
            while (true) {
                Drug du = (Drug)in.readObject();
                drugs.add(du);
                if(du.id >= Drug.did)
                    Drug.did = du.id + 1;
            }
        }
        catch (EOFException eof) {
            System.out.println("Load of drugs completed :)");
        }
        catch (IOException e) {

        }
        catch (ClassNotFoundException e) {
            System.out.println();
        }

    }

    public static void loadvisit() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(visitpath))) {
            while (true) {
                Visit vi = (Visit)in.readObject();
                visits.add(vi);
                if(vi.id >= Visit.vid)
                    Visit.vid = vi.id + 1;
            }
        }
        catch (EOFException eof) {
            System.out.println("Load of visits completed :)");
        }
        catch (IOException e) {

        }
        catch (ClassNotFoundException e) {
            System.out.println();
        }
    }

    public static void loadmessage() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(messagepath))) {
            while (true) {
                Message me = (Message)in.readObject();
                messages.add(me);
                if(me.id >= Message.mid)
                    Message.mid = me.id + 1;
            }

        }
        catch (EOFException eof) {
            System.out.println("Load of messages completed :)");
        }
        catch (IOException e) {

        }
        catch (ClassNotFoundException e) {
            System.out.println();
        }
    }



      //++++++++++++++++++++++++++++++++++ show\switch ++++++++++++++++++++++++++++++++

      public static void showdrugs() {
        int i = 1;
        for(Drug dr:File.drugs){
            System.out.println(i+" - " + dr.tostring());
            i++;
        }

      }


      public static void showdoctors() {
          int i = 1;
          for(Doctor d:File.doctors) {
              System.out.println(i+" - "+d.tostring());
              i++;
          }
      }

      public static void showvisits() {
        int i = 1;
        for(Visit v : File.visits){
            System.out.println(i+" - "+ v.tostring());
            i++;
        }


      }

      public static void showpatient() {
        int i = 1;
        for(Patient p : File.patients) {
            System.out.println(i + " - " + p.tostring());
            i++;
         }
      }

      public static void showmessages() {
        int i = 1;
        for(Message m : File.messages) {
            System.out.println(i + " - " + m.tostring());
            i++;
        }
      }

      public static Patient switchpatients(long id) {
        Patient p = null;
        for(Patient pe:File.patients) {
            if(pe.nationalcode == id) {
                p = pe;
                break;
            }
        }
        return p;
      }


      public static Visit switchvisits(int id) {
          Visit visit = null;
          for(Visit vi:File.visits){
            if(vi.id == id ) {
                visit = vi;
                break;
            }
          }
        return visit;
      }

}