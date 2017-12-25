package vck.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vck.dao.SampleDAO;
import vck.pojo.MyDetails;

@WebServlet(description = "Delete Data", urlPatterns = { "/DeleteList" })
public class DeleteList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("Name");
		MyDetails info = new MyDetails();
		info.setName(name);
		SampleDAO.deleteDataMongo(info);
		response.sendRedirect("DataList");
	}
}
