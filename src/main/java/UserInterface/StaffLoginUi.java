package UserInterface;

import Models.Staff;

import java.util.*;

public class StaffLoginUi {
    public List<Staff> getCredentials(){
        Scanner scanner=new Scanner(System.in);
        Staff staff=new Staff();

        List<Staff> staffdetails=new ArrayList<Staff>();
        Map<Integer,String> credentials=new HashMap<Integer, String>();
        System.out.println("Enter your staff ID");
        staff.setStaffId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter your password");
        staff.setPassword(scanner.nextLine());
        staffdetails.add(staff);
        return staffdetails;
    }
}
