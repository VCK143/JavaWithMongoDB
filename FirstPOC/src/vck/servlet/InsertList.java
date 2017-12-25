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

@WebServlet(description = "Controller", urlPatterns = { "/InsertList" })
public class InsertList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String qual = request.getParameter("qual");

		MyDetails info = new MyDetails();
		info.setName(name);
		info.setAge(age);
		info.setQual(qual);
		int status = SampleDAO.insertDataMongo(info);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("FirstPage.html").include(request, response);
		} else {
			out.println("Sorry! Unable to insert record");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
