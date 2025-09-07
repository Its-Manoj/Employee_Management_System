package EMP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


    
	@SuppressWarnings("serial")
	@WebServlet("/delete")
	public class DeleteEmployeeServlet extends GenericServlet {
		public DeleteDAO ob = null;

		public void init() throws ServletException {
			ob = new DeleteDAO();
		}

		public void service(ServletRequest req,ServletResponse res)throws
	   ServletException,IOException{
	int k = ob.Delete(req);
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	if(k>0) {
	pw.println("Employee deleted Successfully...<br>");

	
	}
	   }

		public void destroy() {
			ob = null;
		}
	
}

