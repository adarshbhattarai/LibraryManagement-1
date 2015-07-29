package business;

import java.io.Serializable;
import java.util.List;

public class CheckoutRecord implements Serializable{
	
	private static final long serialVersionUID = 7734790018617615999L;
	private List<CheckoutRecordEntry> entries;

	public List<CheckoutRecordEntry> getEntries() {
		return entries;
	}
	
	public void addEntry(CheckoutRecordEntry entry){
		entries.add(entry);
	}

	
	
	
}
