package prob3;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import helperclasses.Book;
import helperclasses.LibraryMember;
import helperclasses.TestData;

public class Problem3 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		p.books = TestData.INSTANCE.getAllBooks().iterator();
		LibraryMember winner = p.detectIfWinnerDuringCheckout(members);
		System.out.println("winner is: " + winner);

	}

	Iterator<Book> books;

	public LibraryMember detectIfWinnerDuringCheckout(List<LibraryMember> mems) {
		//return null;
		// fix this
		return mems.stream()
				.filter(mem -> PredicateWithException
						.unchecked((LibraryMember m) -> (m.checkout(books.next().getNextAvailableCopy(),
								LocalDate.now(), LocalDate.of(2015, 9, 1)).getCheckoutRecordEntries().size() == 10))
				.test(mem))

		.findFirst().orElse(null);

	}
}
