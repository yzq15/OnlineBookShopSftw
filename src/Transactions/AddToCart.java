package Transactions;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DataSource.BookFinder;
import DataSource.BookGateway;
import Domain.Book;

import Domain.ShoppingCart;
import Domain.User;

@WebServlet("/cart")
public class AddToCart extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int isbn = Integer.parseInt(request.getParameter("isbn").replaceAll("[^0-9]+",""));
		String bookISBN = request.getParameter("isbn");
		ShoppingCart cart = User.getCustomer().getCart();
		BookGateway bookgw = BookFinder.getBook(bookISBN);
		Book book = new Book(bookgw.getId()+"", bookgw.getAuthor(), bookgw.getTitle(), bookgw.getPrice(), bookgw.getQty());
		String content = "";
		if (book.getCopies() <= 0) {
			content += "<div class='container'>";
			content += "Sorry the book is not available anymore!";
			content += "</div>";
		} else {
			content += "<div class='container'>";
			cart.addBook(book);
			content += "Book was added successfully!";
			book.setCopies(book.getCopies()-1);
			bookgw.setQty(book.getCopies());
			content += "</div>";
			content += "<div class='container'>";
			content += "<form action='cart/view' method='post'>";
			content += "<button type='submit' name='isbn' value='"+isbn+"' class='btn btn-default'>Checkout</button>";
			content += "</form>";
			content += "</div>";
		}
		request.setAttribute("content", content);
		try {
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
