package EMP;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddDAO {

	public int k=0;
	
	public int Add(EmployeeBean eb) {
	
		try {
			
			Connection con=DBconnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("insert into  employees (id,Name,Designation,Salary,Email) values(?,?,?,?,?)");
			ps.setInt(1,eb.getId());
			ps.setString(2, eb.getName());
			ps.setString(3, eb.getDesignation());
			ps.setDouble(4, eb.getSalary());
			ps.setString(5, eb.getEmail());
			
			k= ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	
	
}
