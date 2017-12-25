package vck.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vck.dao.SampleDAO;
import vck.pojo.MyDetails;

@WebServlet(description = "Update Data", urlPatterns = { "/EditList" })
public class EditList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Name");
		MyDetails info = SampleDAO.getMyDetailsByName(name);
		out.print("<form action='UpdateList' method='post' style='background-color: yellow;'>");
		out.print("<div align='center'><h1>Update Your Details Below</h1>");
		out.print("<table><tr><th style='text-align: left;'>Name :</th><td><input name='name' type='text' value='"
				+ info.getName() + "'></td></tr>");
		out.print("<tr><th style='text-align: left;'>Age :</th><td><input name='age' type='number' value='"
				+ info.getAge() + "'></td></tr>");
		out.print("<tr><th style='text-align: left;'>Qualification:</th><td><input name='qual' type='text' value='"
				+ info.getQual() + "'></td></tr>");
		out.print(
				"<tr align='center'><td colspan=2><button name='submit' type='submit'>Edit &amp; Submit</button></td></tr>");
		out.print("</table></div></form>");
		out.close();
	}
}
