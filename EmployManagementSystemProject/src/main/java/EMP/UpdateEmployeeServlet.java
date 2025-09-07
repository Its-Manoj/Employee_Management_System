package EMP;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        UpdateDAO dao = new UpdateDAO();
        int result = dao.update(req);

        if (result > 0) {
            pw.println(" Employee Updated Successfully...");
        } else {
            pw.println(" No fields provided to update or Employee ID not found.");
        }
    }
}