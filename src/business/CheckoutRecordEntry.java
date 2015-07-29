package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable {
	
	private static final long serialVersionUID = 793437773001231214L;
	private BookCopy bookCopy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	public CheckoutRecordEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
		this.bookCopy = bookCopy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	BookCopy getBookCopy() {
		return bookCopy;
	}
	LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	LocalDate getDueDate() {
		return dueDate;
	}
}
