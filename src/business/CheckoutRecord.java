package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable{
	
	private static final long serialVersionUID = 7734790018617615999L;
	private List<CheckoutRecordEntry> entries = new ArrayList<CheckoutRecordEntry>();;
	
	public CheckoutRecord() {
		//entries = new ArrayList<>();
	}

	public List<CheckoutRecordEntry> getEntries() {
		return entries;
	}
	
	public void addEntry(CheckoutRecordEntry entry){
		System.out.println(entry.getCheckoutDate().toString());
		System.out.println(entry.getDueDate().toString());
		System.out.println(entry.getBookCopy().getCopyNum());
		entries.add(entry);
	}

	
	
	
}
