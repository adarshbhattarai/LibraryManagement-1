package business;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
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
	
	public HashMap<String, LibraryMember> getAllMembers(){
		DataAccess da = new DataAccessFacade();
		return da.readMemberMap();
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
		DataAccess da = new DataAccessFacade();
		return da.searchBook(isbn);
	}

	/**
	 * Looks up book by isbn to see if it exists, throw exceptioni. Else add the
	 * book to storage
	 */
	public boolean addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors)
			throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		Book book = searchBook(isbn);
		if (book != null && book.getIsbn().equals(isbn))
			throw new LibrarySystemException("Book with isbn " + isbn + " is in the library collection!");
		book = new Book(isbn, title, maxCheckoutLength, authors);
		da.saveNewBook(book);
		return true;
	}

	public boolean addBookCopy(String isbn) throws LibrarySystemException {
		Book book = searchBook(isbn);
		DataAccess da = new DataAccessFacade();
		if (book == null)
			throw new LibrarySystemException("No book with isbn " + isbn + " is in the library collection!");
		book.addCopy();
		da.updateBook(book);
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
	public CheckoutRecordEntry checkoutBook(String memberId, String isbn) throws LibrarySystemException {
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
		if(!book.isAvailable()){
			throw new LibrarySystemException("Book with isbn " + isbn + " isnot available in the library collection!");
		}
		
		BookCopy availableCopy = book.getNextAvailableCopy();
		
		//checkout of book
		LocalDate checkoutDate = LocalDate.now();
		int maxCheckoutLength = book.getMaxCheckoutLength();
		LocalDate dueDate = checkoutDate.plusDays(maxCheckoutLength);
		CheckoutRecordEntry entry = new CheckoutRecordEntry(availableCopy, checkoutDate, dueDate);
		CheckoutRecord record = libraryMember.getRecord();
		record.addEntry(entry);
		da.updateMember(libraryMember);
		availableCopy.changeAvailability();
		da.updateBook(book);
		return entry;

	}
	
	@Override
	public List<CheckoutRecordEntry> printCheckoutRecord(String memberId) throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		// check for ID
		if (da.searchMember(memberId) == null && !da.searchMember(memberId).getMemberId().equals(memberId)) {
			throw new LibrarySystemException("Library member with MemberId " + memberId + " doesnot exists.");
		}
		List<CheckoutRecordEntry> entries = da.searchMember(memberId).getRecord().getEntries();
		if(entries.size()==0){
			throw new LibrarySystemException("Library member with MemberId " + memberId + " has no checkouts yet.");
		}
		return entries;
		//return entries;
		
//		for(CheckoutRecordEntry entry : entries){
//			Book book = entry.getBookCopy().getBook();
//			String isbn = book.getIsbn();
//			int copyNumber = entry.getBookCopy().getCopyNum();
//			LocalDate checkoutDate = entry.getCheckoutDate();
//			LocalDate dueDate = entry.getDueDate();
//			
//		}

	}
	
	//get list of books with overdue if present
//	public LibraryMember getOverDue(Book book) throws LibrarySystemException{
//		
//	}

}
