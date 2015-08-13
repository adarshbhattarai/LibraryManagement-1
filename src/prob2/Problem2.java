package prob2;

import helperclasses.CheckoutRecordEntry;
import helperclasses.LibraryMember;
import helperclasses.TestData;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/*
 * Print to the console the list of book Title – in sorted order -- 
 * in which the book has been checked out on June 27, 2015. 
 * The ordering of the book title is as follows: First sort by the length 
 * of the title (number of characters), then by alphabetical order.  
 */
public class Problem2 {

	public static void main(String[] args) {
		//use this list
		List<CheckoutRecordEntry> list = TestData.INSTANCE.getAllEntries();
		List<String> bookTitles = list.stream()
				.filter(e -> e.getCheckoutDate().equals(LocalDate.of(2015, 6, 27)))
				.sorted(Comparator.comparing((CheckoutRecordEntry e) -> e.getCopy().getBook().getTitle().length())
						.thenComparing((CheckoutRecordEntry e) -> e.getCopy().getBook().getTitle()))
				
				.map(e -> e.getCopy().getBook().getTitle())
				.distinct()
				.collect(Collectors.toList());
		System.out.println(bookTitles);
	}
	

}
