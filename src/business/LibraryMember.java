package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {

	public LibraryMember(String id, String f, String l, String t, Address a) {
		super(f, l, t, a);
		this.memberId = id;
		record = new CheckoutRecord();
	}

	private static final long serialVersionUID = -5579120185490530713L;
	private String memberId;
	private CheckoutRecord record;

	public String getMemberId() {
		return memberId;
	}
	public CheckoutRecord getRecord() {
		return record;
	}
	public void addRecord(CheckoutRecord record){
		
		this.record = record;
	}
	
	
}
