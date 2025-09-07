package EMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletRequest;

public class UpdateDAO {

    public int update(ServletRequest req) {
        int k = 0;
        try {
            Connection con = DBconnection.getCon();

            StringBuilder query = new StringBuilder("UPDATE EMPLOYEES SET ");
            List<Object> params = new ArrayList<>();

            String name = req.getParameter("Name");
            if (name != null && !name.trim().isEmpty()) {
                query.append("Name=?, ");
                params.add(name);
            }

            String designation = req.getParameter("Designation");
            if (designation != null && !designation.trim().isEmpty()) {
                query.append("Designation=?, ");
                params.add(designation);
            }

            String salaryStr = req.getParameter("Salary");
            if (salaryStr != null && !salaryStr.trim().isEmpty()) {
                query.append("Salary=?, ");
                params.add(Double.parseDouble(salaryStr));
            }

            String email = req.getParameter("Email");
            if (email != null && !email.trim().isEmpty()) {
                query.append("Email=?, ");
                params.add(email);
            }

            // Remove trailing comma and space
            if (params.isEmpty()) return 0; // No fields to update

            query.setLength(query.length() - 2);
            query.append(" WHERE id=?");

            int id = Integer.parseInt(req.getParameter("id"));
            params.add(id);

            PreparedStatement ps = con.prepareStatement(query.toString());

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            k = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}