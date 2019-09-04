package Domain;

import java.util.LinkedList;
import java.util.List;

// Dummy fake data for book shop
public class Persistence {
	public static List<Book> books;
	public static List<Book> getAllBooks(){
		if (books == null) {
			books = new LinkedList<Book>();
			books.add(new Book("111-222-333", "Thomas H. Cormen", "Introduction to Algorithms",
					150.3f, 100));
			books.add(new Book("444-555-666", "Andy Hunt and Dave Thomas", "The Pragmatic Programmer",
					200.8f, 200));
		}
		return books;
	}
	public static Book getBook(String isbn) {
		for (Book b: getAllBooks()) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		return null;
	}
	public static boolean removeBooks(String isbn) {
		for (Book b: getAllBooks()) {
			books.remove(b);
			return true;
		}
		return false;
	}
}
