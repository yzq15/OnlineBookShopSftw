package DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Domain.Book;


public class BookFinder {
	private static final String findAvailableBooksStatement = 
				"SELECT * from books WHERE copies > 0";
	
	public List<BookGateway> findAvailableBooks(){
		List<BookGateway> result = new ArrayList<>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAvailableBooksStatement);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getInt(1));
				int id = rs.getInt(1); // get column 1
				String title = rs.getString(2); // get column 2
				String author = rs.getString(3); // col 3
				int price = rs.getInt(4);
				int qty = rs.getInt(5);
				result.add(new BookGateway(id, title, author, price, qty));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public static BookGateway getBook(String isbn) {
		List<BookGateway> books = (new BookFinder()).findAvailableBooks();
		for (BookGateway b: books) {
			if (b.getId() == Integer.parseInt(isbn)) {
				return b;
			}
		}
		return null;
	}
}
