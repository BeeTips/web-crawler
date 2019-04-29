package dao;

import config.DBConnection;
import model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CurreXDao {
    public static void insertRecord(Currency currency){
        DBConnection obj_DBConnection=new DBConnection();
        Connection connection=obj_DBConnection.get_connection();
        PreparedStatement ps=null;
        try {
            String query="insert into rates set rate_name=?,rate_value=?";
            ps=connection.prepareStatement(query);
            ps.setString(1, currency.getName());
            ps.setDouble(2, currency.getRate());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
