import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        File.loaddoctor();
        File.loadpatient();
        File.loaddrug();
        File.loadvisit();
        File.loadmessage();
        while(true) {
            try {
                System.out.println("\nchoose for switching...\n");
                System.out.println("1  : add doctor");
                System.out.println("2  : add Patient");
                System.out.println("3  : add drug ");
                System.out.println("4  : add visit");
                System.out.println("5  : add message");
                System.out.println("6  : remove doctor");
                System.out.println("7  : remove Patient");
                System.out.println("8  : remove drug");
                System.out.println("9  : remove visit");
                System.out.println("10 : remove message");
                System.out.println("11 : show doctors");
                System.out.println("12 : show patient ");
                System.out.println("13 : show drugs");
                System.out.println("14 : show visits");
                System.out.println("15 : show message");
                System.out.println("16 : exit");
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                switch (n) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        addPatient();
                        break;
                    case 3:
                        addDrug();
                        break;
                    case 4:
                        addvisit();
                        break;
                    case 5:
                        addmessage();
                        break;
                    case 6:
                        removeDoctor();
                        break;
                    case 7:
                        removePatient();
                        break;
                    case 8:
                        removeDrugs();
                        break;
                    case 9:
                        removeVisit();
                        break;
                    case 10:
                        removeMessage();
                        break;
                    case 11:
                        File.showdoctors();
                        break;
                    case 12:
                        File.showpatient();
                        break;
                    case 13:
                        File.showdrugs();
                        break;
                    case 14:
                        File.showvisits();
                        break;
                    case 15:
                        File.showmessages();
                        break;
                    case 16:
                        System.exit(0);
                        break;
                    default:
                    System.out.println("choose a number in this rang...");
                        break;
                }

                
            } 
            catch (Exception e) {
                System.out.println("choose a number in this rang...");
            }
        }
    }

    //++++++++++++++++++++++++++++++++++++++++  Adding  +++++++++++++++++++++++++++++++++

    public static void addDoctor() {
        try {
            Scanner nu = new Scanner(System.in);
            Scanner st = new Scanner(System.in);
            System.out.print("Enter doctors name : ");
            String name = st.nextLine();
            System.out.print("Enter doctors nationalcode : ");
            long nationalcode = nu.nextLong();
            System.out.print("Enter doctors specialty : ");
            String specialty = st.nextLine();
            System.out.print("Enter doctors medical Code : ");
            int medicalcode = nu.nextInt();
            Doctor doctor = new Doctor(name, nationalcode, specialty, medicalcode);
            System.out.println(doctor.tostring());
            doctor.save();
        } catch (Exception e ){
            System.out.println("Enter correct answer.");
        }
    }

    public static void addPatient() {
        try {
            Scanner nu = new Scanner(System.in);
            Scanner st = new Scanner(System.in);
            System.out.print("Enter Patiens name : ");
            String name = st.nextLine();
            System.out.print("Enter Patiens nationalcode : ");
            long nationalcode = nu.nextLong();
            System.out.print("Enter patiens illness : ");
            String illness = st.nextLine();
            Patient patient = new Patient(name, nationalcode, illness);
            System.out.println(patient.tostring());
            patient.save();
        } catch(Exception e) {
            System.out.println("Enter correct answer.");
        }
    }

    public static void addDrug() {
        try {
            Scanner st = new Scanner(System.in);
            System.out.print("Enter drugs name : ");
            String name = st.nextLine();
            System.out.print("Enter drugs company : ");
            String company = st.nextLine();
            System.out.print("Enter for which illness : ");
            String illness = st.nextLine();
            System.out.print("Enter Makedate : ");
            String makedate = st.nextLine();
            System.out.print("Enter expiredata : ");
            String expiredare = st.nextLine();
            System.out.print("Enter description : ");
            String description = st.nextLine();
            Drug drug = new Drug(name,company,illness,makedate,expiredare,description);
            System.out.println(drug.tostring());
            drug.save();
        } catch (Exception e) {
            System.out.println("Enter correct answer.");
        }
    }

    public static void addvisit() {
        try {
            Scanner nu = new Scanner(System.in);
            Scanner st = new Scanner(System.in);
            Scanner nul = new Scanner(System.in);
            System.out.println("Enter doctors number : ");
            File.showdoctors();
            int n;
            n = nu.nextInt();
            Doctor doctor ;
            doctor = File.doctors.get(n-1);
            System.out.println("Enter drugs number : ");
            File.showdrugs();
            n = nu.nextInt();
            Drug drug;
            drug = File.drugs.get(n-1);
            System.out.println("Enter data : ");
            String data = st.nextLine();
            System.out.println("Enter patients National Code : ");
           long number = nul.nextLong();
            Patient patient = File.switchpatients(number);
            if(patient == null){
                System.out.println("Not found patient\ncant save!");
            }
            else {
                Visit visit = new Visit(doctor,patient,drug,data);
                System.out.println(visit.tostring());
                visit.save();
            }
        } catch(Exception e) {
            System.out.println("Enter correct answer.");
        }
    }

    public static void addmessage() {
        try {
            Scanner nu = new Scanner(System.in);
            Scanner st = new Scanner(System.in);
            Scanner nul = new Scanner(System.in);
            System.out.println("Enter number of doctor : ");
            File.showdoctors();
            int n = nu.nextInt();
            Doctor doctor;
            doctor = File.doctors.get(n-1);
            System.out.println("Enter patients National Code : ");
            long number = nul.nextLong();
            Patient patient = File.switchpatients(number);
            while (patient == null) {
                System.out.println("Ther isnt any patient with this code!");
                System.out.println("Enter patients National Code : ");
                number = nul.nextLong();
                patient = File.switchpatients(number);
            }
            System.out.println("Enter subject : ");
            String sub = st.nextLine();
            System.out.println("Enter data : ");
            String dat = st.nextLine();
            System.out.println("Enter id of visit : ");
            n = nu.nextInt();
            Visit vi = File.switchvisits(n);
            while ((vi.doctor.nationalcode != doctor.nationalcode) || (vi.patient.nationalcode != patient.nationalcode)) {
                System.out.println("Visit dont match with that doctor or patient.");
                System.out.println("Enter id of visit : ");
                n = nu.nextInt();
                vi = File.switchvisits(n);
            }
            while(vi == null){
                System.out.println("Not found visit with this id\nEnter id of visit : ");
                n = nu.nextInt();
                vi = File.switchvisits(n);
            }

            Message message = new Message(doctor,patient,sub,dat,vi);
            System.out.println(message.tostring());
            message.save();
            
        } catch (Exception e) {
                System.out.println("Enter correct answer.");
            }

    }

    //+++++++++++++++++++++++++++++++++++++++++ Removing +++++++++++++++++++++++++++


    public static void removeDoctor() {
        try {
            System.out.println("Enter number of doctor to remove : ");
            File.showdoctors();
            Scanner nu = new Scanner(System.in);
            int n = nu.nextInt();
            Doctor doc;
            doc = File.doctors.get(n-1);
            doc.remove();
        }catch (Exception e){
            System.out.println("Enter correct answer.");
        }

    }

    public static void removePatient() {
        try {
            System.out.println("Enter national id of patient to remove : ");
            Scanner nu = new Scanner(System.in);
            long n = nu.nextLong();
            for(Patient p:File.patients)
                if(p.nationalcode == n) {
                    p.remove();
                    break;
                }

        }catch (Exception e) {
            System.out.println("Enter correct answer.");
        }

    }

    public static void removeDrugs() {
        try {
            System.out.println("Enter number of drug for removing : ");
            File.showdrugs();
            Scanner nu = new Scanner(System.in);
            int n = nu.nextInt();
            Drug dr = File.drugs.get(n-1);
            dr.remove();
        }catch (Exception e) {
            System.out.println("Enter correct answer.");
        }

    }

    public static void removeVisit() {
        try {
            Scanner nu = new Scanner(System.in);
            System.out.println("Enter the visit id : ");
            int n = nu.nextInt();
            for(Visit v:File.visits)
                if(v.id == n) {
                    v.remove();
                    break;
                }

        }catch (Exception e) {
            System.out.println("Enter correct answer.");
        }

    }

    public static void removeMessage() {
        try {
            Scanner nu = new Scanner(System.in);
            System.out.println("Enter the message id : ");
            int n = nu.nextInt();
            for(Message m:File.messages)
                if(m.id == n){
                    m.remove();
                    break;
                }


        }catch (Exception e) {
            System.out.println("Enter correct answer.");
        }

    }

}