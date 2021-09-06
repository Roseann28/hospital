package Models;

public class Receptionist extends Staff {
    private String department="Accomodate";
    private String password="accomodate01";

    public Receptionist(){
        super.setDepartment(department);
        super.setPassword(password);
    }
    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
