package Transactions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Domain.Book;

@WebServlet("/books")
public class ViewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//List<Book> books = Persistence.getAllBooks();
		List<Book> books = Book.getAllAvailableBooks();
		
		request.setAttribute("books", books);
		try {
			request.getRequestDispatcher("viewBooks.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
