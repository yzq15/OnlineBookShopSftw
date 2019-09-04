package authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// e.g. http://localhost:8080/OnlineBookShopProject/Login?userName=YangZhou&password=unimelb
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("Hello from GET method");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Hello from Get "+ userName + " " + password+" </h3>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (getServletConfig().getInitParameter("userNameI").equals(userName) &&
				getServletConfig().getInitParameter("passwordI").equals(password)) {
			response.sendRedirect("success.jsp");
		} else {
			writer.println("<h3>Error, wrong Password and UserName</h3>");
			writer.println("<p>Go back to <a href=\"index.html\">Index</a></p>");
		}
		
		System.out.println("Hello from POST method");

	}

}
