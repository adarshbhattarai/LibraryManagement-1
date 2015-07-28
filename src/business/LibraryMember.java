package business;

public class LibraryMember extends Person {

	public LibraryMember(String f, String l, String t, Address a, String id) {
		super(f, l, t, a);
		this.memberId = id;
	}

	private static final long serialVersionUID = -5579120185490530713L;
	private String memberId;

	public String getMemberId() {
		return memberId;
	}
}
