package Models;

public class Staff {
    private String name;
    private int staffId;
    private String department;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String AddPerson() {
        String query;
        query = "insert into staff(staffId,name,department,password) values("
                + getStaffId() + ",'" + getName() + "'," +
                "'" + getDepartment() + "'," + "'" + getPassword() + "')";
        System.out.println("Executing sql: " + query);
        return query;
    }

    public String updatePerson() {
        String query;
        query = "update staff set ";

        String setCol = "";

        if (getName() != null && !getName().trim().equals(""))
            setCol += "name='" + getName();

        if (getDepartment() != null && !getDepartment().trim().equals(""))
            setCol += "department='" + getDepartment();

        if (getPassword() != null && !getPassword().trim().equals(""))
            setCol += "password='" + getPassword();

        query += setCol;

        query += " where staffId=" + getStaffId();
        return query;
    }
}