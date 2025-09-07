package EMP;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends GenericServlet {
	public EmployeeBean eb = null;
	public AddDAO ob = null;

	public void init() throws ServletException {
		eb = new EmployeeBean();
		ob = new AddDAO();
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		eb.setId(Integer.parseInt(req.getParameter("id")));
		eb.setName(req.getParameter("Name"));
		eb.setDesignation(req.getParameter("Designation"));
		eb.setSalary(Double.parseDouble(req.getParameter("Salary")));
		eb.setEmail(req.getParameter("Email"));
		int k = ob.Add(eb);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if (k > 0) {
			pw.println("!...Employee Added Successfully...!<br>");
			
		}
	}

	public void destroy() {
		ob = null;
		eb = null;
	}
}