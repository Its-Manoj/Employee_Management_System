package EMP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/viewall")
public class View_All_EmployeesServlet extends GenericServlet {
    private View_All_EmployeesDAO ob;

    public void init() throws ServletException {
        ob = new View_All_EmployeesDAO();
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        ArrayList<EmployeeBean> list = ob.fetchAll();

        if (list.isEmpty()) {
            pw.println("<h3 style='color:red;'>❌ No employees found.</h3>");
        } else {
            pw.println("<h2>Employees Records:</h2>");
            pw.println("<table border='1' cellpadding='8'>");
            pw.println("<tr><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th><th>Email</th></tr>");
            for (EmployeeBean emp : list) {
                pw.println("<tr>");
                pw.println("<td>" + emp.getId() + "</td>");
                pw.println("<td>" + emp.getName() + "</td>");
                pw.println("<td>" + emp.getDesignation() + "</td>");
                pw.println("<td>" + emp.getSalary() + "</td>");
                pw.println("<td>" + emp.getEmail() + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        }
    }

    public void destroy() {
        ob = null;
    }
}
