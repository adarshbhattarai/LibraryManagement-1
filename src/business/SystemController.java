package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2434939807943261004L;
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if (!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if (!passwordFound.equals(password)) {
			throw new LoginException("Passord does not match password on record");
		}
		currentAuth = map.get(id).getAuthorization();

		
	}

	/**
	 * This method checks if memberId already exists -- if so, it cannot be
	 * added as a new member, and an exception is thrown. If new, creates a new
	 * LibraryMember based on input data and uses DataAccess to store it.
	 * 
	 */
	public void addNewMember(String memberId, String firstName, String lastName, String telNumber, Address addr)
			throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		LibraryMember libraryMember = da.searchMember(memberId);
		if (libraryMember != null && libraryMember.getMemberId().equals(memberId)) {
			throw new LibrarySystemException("Library member with MemberId " + memberId + " already exists.");
		} else {
			LibraryMember member = new LibraryMember(memberId, firstName, lastName, telNumber, addr);
			da.saveNewMember(member);
		}
	}

	/**
	 * Reads data store for a library member with specified id. Ids begin at
	 * 1001... Returns a LibraryMember if found, null otherwise
	 * 
	 */
	public LibraryMember search(String memberId) {
		DataAccess da = new DataAccessFacade();
		LibraryMember libraryMember = da.searchMember(memberId);
		return libraryMember;
	}

	/**
	 * Same as creating a new member (because of how data is stored)
	 */
	public void updateMemberInfo(String memberId, String firstName, String lastName, String telNumber, Address addr)
			throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		LibraryMember libraryMember = da.searchMember(memberId);
		if (libraryMember != null && libraryMember.getMemberId().equals(memberId)) {
			LibraryMember member = new LibraryMember(memberId, firstName, lastName, telNumber, addr);
			da.updateMember(member);
		} else {
			throw new LibrarySystemException("Library member with MemberId " + memberId + " doesnot exists.");
		}
	}

	@Override
	public Book searchBook(String isbn) {
		try {
			DataAccess da = new DataAccessFacade();
			return da.searchBook(isbn);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		 return null;
	}

	/**
	 * Looks up book by isbn to see if it exists, throw exceptioni. Else add the
	 * book to storage
	 */
	public boolean addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors)
			throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
//		Book book = searchBook(isbn);
//		if (book != null && book.getIsbn().equals(isbn))
//			throw new LibrarySystemException("Book with isbn " + isbn + " is in the library collection!");
		Book book = new Book(isbn, title, maxCheckoutLength, authors);
		da.saveNewBook(book);
		return true;
	}

	public boolean addBookCopy(String isbn) throws LibrarySystemException {
		Book book = searchBook(isbn);
		if (book == null)
			throw new LibrarySystemException("No book with isbn " + isbn + " is in the library collection!");
		book.addCopy();
		return true;
	}

	public static void main(String[] args) throws LibrarySystemException {

	}

	/**
	 * Looks up Book by isbn from data store. If not found, an exception is
	 * thrown. If no copies are available for checkout, an exception is thrown.
	 * If found and a copy is available, member's checkout record is updated and
	 * copy of this publication is set to "not available"
	 */
	@Override
	public void checkoutBook(String memberId, String isbn) throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		// check for ID
		LibraryMember libraryMember = da.searchMember(memberId);
		if (libraryMember == null && !libraryMember.getMemberId().equals(memberId)) {
			throw new LibrarySystemException("Library member with MemberId " + memberId + " doesnot exists.");
		}
		//check for book
		Book book = searchBook(isbn);
		if (book == null && !book.getIsbn().equals(isbn)){
			throw new LibrarySystemException("Book with isbn " + isbn + " isnot in the library collection!");
		}
		//check for availability of book
		BookCopy[] copies = book.getCopies();
		boolean isAvailable = false;
		BookCopy availableCopy = null;
		for(BookCopy copy : copies){
			if(copy.isAvailable()){
				isAvailable = true;
				availableCopy = copy;
				break;
			}
		}
		if(!isAvailable){
			throw new LibrarySystemException("Book with isbn " + isbn + " isnot available in the library collection!");
		}
		//checkout of book
		LocalDate checkoutDate = LocalDate.now();
		int maxCheckoutLength = book.getMaxCheckoutLength();
		LocalDate dueDate = checkoutDate.plusDays(maxCheckoutLength);
		CheckoutRecordEntry entry = new CheckoutRecordEntry(availableCopy, checkoutDate, dueDate);
		libraryMember.getRecord().addEntry(entry);

	}

	@Override
	public void printCheckoutRecord(String memberId) throws LibrarySystemException {
		// TODO Auto-generated method stub

	}

}
