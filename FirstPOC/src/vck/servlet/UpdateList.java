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

@WebServlet(description = "Update List", urlPatterns = { "/UpdateList" })
public class UpdateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String qual = request.getParameter("qual");

		MyDetails details = new MyDetails();
		details.setName(name);
		details.setAge(Integer.parseInt(age));
		details.setQual(qual);

		int status = SampleDAO.updateDataMongo(details);
		if (status > 0) {
			response.sendRedirect("DataList");
		} else {
			out.println("Sorry! unable to Update record");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
