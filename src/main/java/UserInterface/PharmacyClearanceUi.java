package UserInterface;

import Models.PhamarcyClearance;
import Util.BillClearance;

import java.util.Scanner;

public class PharmacyClearanceUi {
    public void getClearance(){
        Scanner scanner=new Scanner(System.in);
        PhamarcyClearance phamarcyClearance=new PhamarcyClearance();
        System.out.println("Enter patient's ailment:");
        phamarcyClearance.setAilment(scanner.nextLine());
        System.out.println("Enter recommended medicine");
        phamarcyClearance.setMedicine(scanner.nextLine());
        System.out.println("Enter Patients bill:");
        phamarcyClearance.setMedicinebill(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter whether bill is cleared:");
        System.out.println("1.CLEARED");
        System.out.println("2.PENDING");
        phamarcyClearance.setClearedbill(BillClearance.values()[scanner.nextInt()-1]);
    }
}
