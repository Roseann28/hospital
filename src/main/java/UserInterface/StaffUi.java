package UserInterface;

import Models.Staff;

import java.util.Scanner;

public class StaffUi {
    public void getDetails(Staff staff){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter your staff id:");
        staff.setStaffId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter your Name:");
        staff.setName(scanner.nextLine());

    }
}
