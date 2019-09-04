package DataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookGateway {
	private int id;
	private String title;
	private String author;
	private float price;
	private int qty;
	
	public BookGateway(int id, String title, String author, float price, int qty) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public float getPrice() {
		return price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int copies) {
		
		try {
			PreparedStatement stmt;
			String str = "UPDATE books SET copies = "+copies+" WHERE isbn = "+id+";";
			System.out.println(str);
			stmt = DBConnection.prepare(str);
			stmt.executeUpdate();
			DBConnection.dbConnection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
