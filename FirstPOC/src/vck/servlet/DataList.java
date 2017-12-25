package vck.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vck.dao.SampleDAO;
import vck.pojo.MyDetails;

@WebServlet(description = "Retrive all Data", urlPatterns = { "/DataList" })
public class DataList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='FirstPage.html'>Add New Detail</a>");
		out.println("<h1>My Details</h1>");

		List<MyDetails> list = SampleDAO.retriveDataMongo();

		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Name</th><th>Age</th><th>Qualification</th><th>Edit</th><th>Delete</th></tr>");
		for (MyDetails info : list) {
			out.print("<tr><td>" + info.getName() + "</td><td>" + info.getAge() + "</td><td>" + info.getQual()
					+ "</td></td><td><a href='EditList?Name=" + info.getName()
					+ "'>Edit</a></td><td><a href='DeleteList?Name=" + info.getName() + "'>Delete</a></td></tr>");
		}
		out.print("</table>");
		out.close();
	}
}
