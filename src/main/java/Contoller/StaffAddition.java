package Contoller;

import Interface.DatabaseLogicI;
import Models.Staff;
import Util.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class StaffAddition extends DatabaseConnection implements DatabaseLogicI<Staff> {

    @Override
    public void add(Staff staff) {
        writeToDatabase(staff.AddPerson());

    }

    @Override
    public List<Staff> view() {
        List<Staff> staff=new ArrayList<Staff>();
        ResultSet resultSet = readFromDatabase("select * from staff");
        try {
            while (resultSet.next()) {
                Staff staff1 = new Staff();
                staff1.setStaffId(resultSet.getInt(1));
                staff1.setName(resultSet.getString(2));
                staff1.setDepartment(resultSet.getString(3));
                staff1.setPassword(resultSet.getString(4));
                staff.add(staff1);
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return staff;
    }

    public String login(int id) {
        List<Staff> staffdetails=new ArrayList<Staff>();
        String password=null;
        Staff staff=new Staff();
        ResultSet resultSet=readFromDatabase("select password from staff where staffid="+id);
        try {
            resultSet.next();
            password=resultSet.getString("password");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return password;
    }

    @Override
    public int update(Staff staff) {
        if (staff==null||staff.getStaffId()==0){
            return 0;
        }else
            writeToDatabase(staff.updatePerson());

        return 1;
    }

    @Override
    public void delete(int id) {
        writeToDatabase("delete from staff where id=" + id);

    }
}
