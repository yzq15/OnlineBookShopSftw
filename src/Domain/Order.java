package Domain;

import java.util.Map;
import java.util.UUID;

public class Order {
	private UUID id;
	private Map<Book, Integer> bookCopies;
	private Customer orderedBy;
	private float totalPrice;
	public Order(Map<Book, Integer> bookCopies, Customer orderedBy) {
		this.bookCopies = bookCopies;
		this.orderedBy = orderedBy;
		for (Map.Entry<Book, Integer> book : bookCopies.entrySet()){
			this.totalPrice += book.getKey().getPrice();
		}
            
	}
}
