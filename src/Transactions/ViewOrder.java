package Transactions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DataSource.BookGateway;
import Domain.Book;
import Domain.User;

@WebServlet("/cart/view")
public class ViewOrder extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<Book, Integer> cart = User.getCustomer().getCart().getBookCopies();
		
		String content = "";
		content += "<div class='container'>";
		content += "<table>";
		for (Map.Entry<Book, Integer> entry : cart.entrySet()){
			content +="<tr><td>" + entry.getKey().getTitle()+"</td></tr>";
		}
		content += "</table>";
		content += "</div>";
		request.setAttribute("content", content);
		try {
			request.getRequestDispatcher("/viewOrder.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
