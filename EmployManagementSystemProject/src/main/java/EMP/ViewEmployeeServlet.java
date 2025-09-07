package EMP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployeeServlet extends GenericServlet {
    private ViewDAO ob;

    public void init() throws ServletException {
        ob = new ViewDAO();
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        try {
            int id = Integer.parseInt(req.getParameter("id")); // Get ID from form
            ArrayList<EmployeeBean> al = ob.view(id);

            if (al.isEmpty()) {
                pw.println("<h3>Employee not found.</h3>");
            } else {
                pw.println("<h3>Employee Details:</h3>");
                
                
                for (EmployeeBean eb : al) {
                    pw.println(eb.getId() + " " + eb.getName() + " " +
                               eb.getDesignation() + " " + eb.getSalary() + " " +
                               eb.getEmail() + " ");
                }
               
            }
        } catch (NumberFormatException e) {
            pw.println("<h3>Invalid Employee ID format.</h3>");
        }
    }

    public void destroy() {
        ob = null;
    }
}