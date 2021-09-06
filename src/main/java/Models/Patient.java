package Models;

import java.sql.Date;

public class Patient {
    private int id;
    private String name;
    private String email;
    private int NationalId;
    private String paymentMethod;

    public int getNationalId() {
        return NationalId;
    }

    public void setNationalId(int nationalId) {
        NationalId = nationalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String addPatient() {
        String query = "insert into patient(name,email,identificationNumber,paymentmethod) values("
                + "'"+getName()+"'," + "'" + getEmail() + "'," +
                    "'" + getNationalId() + "'," + "'" + getPaymentMethod() + "')";

        return query;
    }
        public String updatePatient(){
        String query;
            query = "update patient set ";

            String setCol = "";

            if (getName() != null && !setCol.trim().equals(""))
                setCol += "name='" + getName();

            if (getEmail() != null && !setCol.trim().equals(""))
                setCol += "email='" + getEmail();

            if (getNationalId() != 0 && !setCol.trim().equals(""))
                setCol += "identificationNumber='" +getNationalId();

            if (getPaymentMethod() != null && !setCol.trim().equals(""))
                setCol += "paymentmethod='" + getPaymentMethod();

            query += setCol;

            query += " where id=" + getId();
            return query;
        }
}
