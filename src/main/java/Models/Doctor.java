package Models;

public class Doctor extends Staff{
    private String department="Medical";
    private String password="doctor01";

    public Doctor(){
        super.setDepartment(department);
        super.setPassword(password);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
