/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatti;

import java.sql.*;
import java.util.*;

public class ViestiDao {
    private Database db;

    public ViestiDao(Database d) {
        this.db = d;
    }
    
    public List<Viesti> haeKaikki() throws  Exception{
        List<Viesti> viestit = new ArrayList<>();
        Connection con = db.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Viesti");
        
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.isBeforeFirst();
        if (!hasOne) {
            return null;
        }
        while (rs.next()) {
            int id = rs.getInt("id");
            String sisalto = rs.getString("sisalto");
            String kayt = rs.getString("kayttaja");
            viestit.add(new Viesti(id, sisalto, kayt));

        }
        rs.close();
        stmt.close();
        return viestit;
    }
    
    public void put(String kayttaja, String sisalto) throws Exception{
        Connection con = db.getConnection();
        Statement stmt = con.createStatement();
        int changes = stmt.executeUpdate("INSERT INTO Viesti (sisalto, kayttaja) VALUES ('"+ sisalto +"', '" + kayttaja + "')");
        stmt.close();
    }
}
