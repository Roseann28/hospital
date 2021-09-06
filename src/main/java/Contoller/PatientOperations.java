package Contoller;

import Interface.DatabaseLogicI;
import Models.Patient;
import Util.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientOperations extends DatabaseConnection implements DatabaseLogicI<Patient> {


    @Override
    public void add(Patient patient) {
        writeToDatabase(patient.addPatient());

    }

    @Override
    public List<Patient> view() {
        List<Patient> patients=new ArrayList<Patient>();
        ResultSet resultSet = readFromDatabase("select * from patient");
        try {
            while (resultSet.next()) {
                Patient patient=new Patient();
                patient.setId(resultSet.getInt(1));
                patient.setName(resultSet.getString(2));
                patient.setEmail(resultSet.getString(3));
                patient.setNationalId(resultSet.getInt(4));
                patient.setPaymentMethod(resultSet.getString(5));
                patients.add(patient);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return patients;
    }



    @Override
    public int update(Patient patient) {
        writeToDatabase(patient.updatePatient());

        return 1;
    }


    @Override
    public void delete(int id) {
        writeToDatabase("delete from patient where id=" + id);
    }
}
