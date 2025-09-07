package EMP;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletRequest;

public class DeleteDAO {
    public int k = 0;

    public int Delete(ServletRequest req) {
        try {
            Connection con = DBconnection.getCon();
            // Correct SQL syntax for DELETE
            PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEES WHERE id=?");
            ps.setString(1, req.getParameter("id"));  
            k = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}

