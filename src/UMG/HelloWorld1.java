package UMG;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class HelloWorld1
 */
public class HelloWorld1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void service(ServletRequest request, ServletResponse response  )
	throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter writer =response.getWriter();
		writer.print("<html><body><h1>Hola Mundo</h1>"+new Date(0).toString()+"</body></html>");

	}


}
