package MX;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UMG.Category;
import UMG.Programa;
import UMG.State;
import UMG.Task;

/**
 * Servlet implementation class TareaServlet
 */
public class TareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TareaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter escribir = response.getWriter();
		escribir.println("<html>");
		escribir.println("	<head>");
		escribir.println("		<title>Anadir Tarea</title>");
		escribir.println("	</head>");
		escribir.println("	<body>");
		escribir.println("		<form method=\"POST\">");
		escribir.println("			<table>");
		escribir.println("				<tr>");
		escribir.println("					<td>Titulo:</td>");
		escribir.println("					<td><input type=\"text\" name=\"title\" /></td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td>Descripcion:</td>");
		escribir.println("					<td><input type=\"text\" name=\"description\" /></td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td>State:</td>");
		escribir.println("					<td>");
		escribir.println("						<select name=\"Estatus\">");
		escribir.println("							<option value=\"RESERVA\" selected>Backlog</option>");
		escribir.println("							<option value=\"A REALIZAR\">To do</option>");
		escribir.println("							<option value=\"EN PROGRESO\">In progress</option>");
		escribir.println("							<option value=\"REALIZADO\">Done</option>");
		escribir.println("						</select>");
		escribir.println("					</td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td>Categoria:</td>");
		escribir.println("					<td><input type=\"text\" name=\"category\" /></td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td>Prioridad:</td>");
		escribir.println("					<td><input type=\"text\" name=\"priority\" /></td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td>Propietario:</td>");
		escribir.println("					<td><input type=\"text\" name=\"owner\" /></td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td>Fecha de Vencimiento:</td>");
		escribir.println("					<td><input type=\"text\" name=\"due_date\" value=\""+ new Date() + "\"/></td>");
		escribir.println("				</tr>");
		escribir.println("				<tr>");
		escribir.println("					<td colspan=\"2\"><input type=\"submit\" value=\"Add\" /></td>");
		escribir.println("				</tr>");
		escribir.println("			</table>");
		escribir.println("		</form>");
		escribir.println("	</body>");
		escribir.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();

		task.setTitle(request.getParameter("title"));
		task.setDescription(request.getParameter("description"));
		task.setOwner(request.getParameter("owner"));
		task.setCategory(new Category(request.getParameter("category")));

		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEE MMM d HH:mm:ss zzz yyyy");
		try {
			task.setDueDate((java.sql.Date) formatter.parse(request.getParameter("due_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			task.setState(State.valueOf(request.getParameter("state")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			task.setPriority(Short.parseShort(request.getParameter("priority")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		task.setCreateDate((java.sql.Date) new Date());

		Programa.dashboard.add(task);

		response.setContentType("text/html");
		PrintWriter escribir = response.getWriter();
		escribir.print("<html><body>" + task.Html() + "</body></html>");
	}

}
