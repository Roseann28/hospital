import Contoller.BillsDrugs;
import Contoller.PatientOperations;
import Contoller.StaffAddition;
import Models.*;
import UserInterface.PatientUi;
import UserInterface.PharmacyClearanceUi;
import UserInterface.StaffLoginUi;
import UserInterface.StaffUi;
import Util.Occupation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StaffAddition staffAddition=new StaffAddition();
        PatientUi patientUi=new PatientUi();
        PharmacyClearanceUi pharmacyClearanceUi=new PharmacyClearanceUi();
        BillsDrugs billsDrugs=new BillsDrugs();
        Patient patient=new Patient();
        PatientOperations patientOperations=new PatientOperations();
        PhamarcyClearance phamarcyClearance=new PhamarcyClearance();
        Staff staff=new Staff();
        System.out.println("==========Welcome to RAM hospital========");
        System.out.println("==========What would you like to do========");
        System.out.println("1.Register staff:");
        System.out.println("2.login");
        int choice=scanner.nextInt();
        scanner.nextLine();
        if (choice==1){
            registerStaff(scanner,staffAddition);
        }else if (choice==2){
            StaffLoginUi staffLoginUi=new StaffLoginUi();
            List<Staff> credentialsList=staffLoginUi.getCredentials();
            String password=staffAddition.login(credentialsList.get(0).getStaffId());
            if (credentialsList.get(0).getPassword().equals(password)){
                    patientDetails(scanner, patientUi,patient);
                    clearAilmentBill(scanner, pharmacyClearanceUi, billsDrugs, phamarcyClearance);


            }else
                System.out.println("invalid credentials");

        }




        System.out.println();



    }

    private static void clearAilmentBill(Scanner scanner, PharmacyClearanceUi pharmacyClearanceUi, BillsDrugs billsDrugs, PhamarcyClearance phamarcyClearance) {
        System.out.println("1.Add prescription");
        System.out.println("2.view prescription");
        System.out.println("3.update prescription");
        System.out.println("4.Delete prescription");
        int choose=scanner.nextInt();
        scanner.nextLine();
        if (choose==1){
            pharmacyClearanceUi.getClearance();
            billsDrugs.add(phamarcyClearance);
        }else if(choose==2){
            List<PhamarcyClearance> clearances=billsDrugs.view();
            List<String> views=new ArrayList<String>();
            for (int i=0;i<clearances.size();i++){
                views.add(String.valueOf(clearances.get(i).getId()));
                views.add(clearances.get(i).getAilment());
                views.add(clearances.get(i).getMedicine());
                views.add(String.valueOf(clearances.get(i).getMedicinebill()));
                views.add(String.valueOf(clearances.get(i).getClearedbill()));
            }
            System.out.println(views);
        }else if(choose==3){
            billsDrugs.update(phamarcyClearance);
        }else if (choose==4){
            int id=scanner.nextInt();
            scanner.nextLine();
            billsDrugs.delete(id);
        }else{
            System.out.println("Invalid choice");
        }
    }

    private static void patientDetails(Scanner scanner, PatientUi patientUi,Patient patient) {
        PatientOperations patientOperations=new PatientOperations();

        int option;
        do {
            System.out.println("======Choose what you would like to do====");
            System.out.println("1.view patients");
            System.out.println("2.add patient");
            System.out.println("3.update patient");
            System.out.println("4.Delete patient");
            System.out.println("0.Exit");
            option= scanner.nextInt();
            if (option == 1) {
                List<Patient> patients=patientOperations.view();
                List<String> views=new ArrayList<String>();
                for (int i=0;i<patients.size();i++){
                    views.add(String.valueOf(patients.get(i).getId()));
                    views.add(patients.get(i).getName());
                    views.add(patients.get(i).getEmail());
                    views.add(String.valueOf(patients.get(i).getNationalId()));
                    views.add(patients.get(i).getPaymentMethod());
                }
                System.out.println(views);
            } else if (option == 2) {
                patientUi.getPatientDetails(patient);
                patientOperations.add(patient);
            } else if (option == 3) {
                patientOperations.update(patient);
            } else if (option == 4) {
                System.out.println("Enter ID");
                int id = scanner.nextInt();
                patientOperations.delete(id);
            }
        }while (option!=0);


    }

    private static void registerStaff(Scanner scanner,StaffAddition staffAddition) {
        Staff staff=null;
        System.out.println("Enter Occupation");
        System.out.println("1.DOCTOR");
        System.out.println("2.RECPTIONIST");
        System.out.println("3.PHARMACIST");
        Occupation occupation=Occupation.values()[scanner.nextInt()-1];
        scanner.nextLine();
        switch (occupation){
            case DOCTOR:
                staff=new Doctor();
                break;
            case RECEPTIONIST:
                staff=new Receptionist();
                break;
            case PHARMACIST:
                staff=new Phamarcist();
                break;
        }
        StaffUi staffUi=new StaffUi();
        staffUi.getDetails(staff);
        staffAddition.add(staff);


    }
}
