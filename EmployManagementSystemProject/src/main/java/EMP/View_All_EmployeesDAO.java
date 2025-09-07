package EMP;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class View_All_EmployeesDAO {
    public ArrayList<EmployeeBean> fetchAll() {
        ArrayList<EmployeeBean> list = new ArrayList<>();
        try {
            Connection con = DBconnection.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT id, Name, Designation, Salary, Email FROM EMPLOYEES");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeBean emp = new EmployeeBean();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("Name"));
                emp.setDesignation(rs.getString("Designation"));
                emp.setSalary(rs.getDouble("Salary"));
                emp.setEmail(rs.getString("Email"));
                list.add(emp);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
