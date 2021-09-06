package Contoller;

import Interface.DatabaseLogicI;
import Models.PhamarcyClearance;
import Util.BillClearance;
import Util.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillsDrugs extends DatabaseConnection implements DatabaseLogicI<PhamarcyClearance> {
    @Override
    public void add(PhamarcyClearance phamarcyClearance) {
        writeToDatabase(phamarcyClearance.addPerson());
    }
    @Override
    public List<PhamarcyClearance> view() {
        List<PhamarcyClearance> phamarcyClearancelist=new ArrayList<PhamarcyClearance>();
        ResultSet resultSet = readFromDatabase("select * from ailment");
        try {
            while (resultSet.next()) {
                PhamarcyClearance phamarcyClearance=new PhamarcyClearance();
                phamarcyClearance.setId(resultSet.getString(1));
                phamarcyClearance.setAilment(resultSet.getString(2));
                phamarcyClearance.setMedicinebill(resultSet.getInt(3));
                phamarcyClearance.setClearedbill(BillClearance.valueOf(resultSet.getString(4)));
                phamarcyClearancelist.add(phamarcyClearance);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return phamarcyClearancelist;
    }

    @Override
    public int update(PhamarcyClearance phamarcyClearance) {
        writeToDatabase(phamarcyClearance.updatePerson());
        return 1;
    }

    @Override
    public void delete(int id) {
        writeToDatabase("delete from ailment where id="+id);

    }
}
