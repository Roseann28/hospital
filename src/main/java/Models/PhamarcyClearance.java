package Models;

import Util.BillClearance;

public class PhamarcyClearance extends AilmentDrugs{
    private int medicinebill;
    private BillClearance clearedbill;

    public int getMedicinebill() {
        return medicinebill;
    }

    public void setMedicinebill(int medicinebill) {
        this.medicinebill = medicinebill;
    }

    public BillClearance getClearedbill() {
        return clearedbill;
    }

    public void setClearedbill(BillClearance clearedbill) {
        this.clearedbill = clearedbill;
    }
    public String addPerson() {
        String query;
        query = "insert into ailment(sickness,drugs,bill,cleared) values("
                +"'" + getAilment() + "'," +
                "'" + getAilment() + "'," + getMedicinebill() + ",'"+getClearedbill()+"')";
        System.out.println("Executing sql: " + query);
        return query;
    }

    public String updatePerson() {
        String query;
        query = "update ailment set ";

        String setCol = "";

        if (getAilment() != null && !getAilment().trim().equals(""))
            setCol += "ailment='" + getAilment();

        if (getMedicine() != null && !getMedicine().trim().equals(""))
            setCol += "drugs='" + getMedicine();
        if (getMedicinebill() != 0 && !setCol.trim().equals(""))
            setCol += "bill='" + getMedicinebill();

        if (getClearedbill() != null && !setCol.trim().equals(""))
            setCol += "password='" + getClearedbill().name();

        query += setCol;

        query += " where staffId=" + getId();
        return query;
    }
}
