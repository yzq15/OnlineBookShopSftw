package Domain;

import java.util.ArrayList;
import java.util.List;

import DataSource.BookFinder;
import DataSource.BookGateway;

public class Book {
	// Book attributes
	private String isbn;
	private String author;
	private String title;
	private float price;
	private int copies;
	
	public Book(String isbn, String author, String title, float price, int copy) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.setCopies(copy);
	}
	
	public static List<Book> getAllAvailableBooks(){
		BookFinder finder = new BookFinder();
		List<Book> result = new ArrayList<Book>();
		List<BookGateway> booksRecords = finder.findAvailableBooks();
		
		for (BookGateway brow : booksRecords) {
			Book book = new Book(String.valueOf(brow.getId()),
								brow.getAuthor(),
								brow.getTitle(),
								brow.getPrice(),
								brow.getQty());
			result.add(book);
		}
		return result;
	}
	
	public void setCopies(int copy) {
		this.copies = copy;
	}
	public String toString() {
		return this.title + " by" + " "+this.author;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public float getPrice() {
		return this.price;
	}
	public int getCopies() {
		return this.copies;
	}
}
