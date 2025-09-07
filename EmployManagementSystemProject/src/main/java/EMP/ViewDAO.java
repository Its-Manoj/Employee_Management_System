package EMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewDAO {
    public ArrayList<EmployeeBean> view(int id) {
        ArrayList<EmployeeBean> al = new ArrayList<>();
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE id = ?");
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeBean eb = new EmployeeBean();
                eb.setId(rs.getInt("id"));
                eb.setName(rs.getString("name"));
                eb.setDesignation(rs.getString("designation"));
                eb.setSalary(rs.getDouble("salary"));
                eb.setEmail(rs.getString("email"));
                al.add(eb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }
}