package ui.controller;

import java.util.List;

import business.CheckoutRecordEntry;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrintCheckoutController {
	@FXML
	private TextField txtMemberSearch;
	@FXML
	private Label lblMsg;

	@FXML
	protected void printCheckout(ActionEvent event) {
		SystemController sc = new SystemController();
		System.out.println("yes");
		try {
			LibraryMember member = sc.search(txtMemberSearch.getText());
			System.out.println("LIBRARY MEMBER CHECKOUT DETAILS");
			System.out.println("--------------------------------");
			System.out.println("Member Details:");
			System.out.println("--------------------------------");
			System.out.println("Member ID: " + member.getMemberId());
			System.out.println("Name: " + member.getFirstName() + " " + member.getLastName());
			System.out.println("Address: " + member.getAddress());
			System.out.println("Telephone Number: " + member.getTelephone());
			System.out.println("--------------------------------");
			List<CheckoutRecordEntry> entries = sc.printCheckoutRecord(txtMemberSearch.getText());
			
			System.out.println("Checkout Details");
			System.out.println("--------------------------------");
			System.out.println("|-----------------------------------------------------------------------|");
			System.out.println("| Book ISBN    |    Copy Number   |    Checkout Date    |    Due Date   |");
			System.out.println("|--------------|------------------|---------------------|---------------|");
			for(CheckoutRecordEntry entry : entries){
				System.out.print("| ");
				System.out.print(entry.getBookCopy().getBook().getIsbn());
				System.out.print("     |      ");
				System.out.print(entry.getBookCopy().getCopyNum());
				System.out.print("           |     ");
				System.out.print(entry.getCheckoutDate());
				System.out.print("      |    ");
				System.out.print(entry.getDueDate());
				System.out.print(" |");
				System.out.print("\n");
			}
			System.out.println("|--------------|------------------|---------------------|---------------|");
			
		} catch (LibrarySystemException e) {
			lblMsg.setText(e.getMessage());
		}
	}
}
