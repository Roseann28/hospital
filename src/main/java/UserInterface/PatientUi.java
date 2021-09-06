package UserInterface;

import Models.Patient;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PatientUi {
    public void getPatientDetails(Patient patient){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Patient's name;");
        patient.setName(scanner.nextLine());
        System.out.println("Enter Email:");
        patient.setEmail(scanner.nextLine());
        System.out.println("Enter identification number");
        patient.setNationalId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Payment Method");
        patient.setPaymentMethod(scanner.nextLine());

    }
}
