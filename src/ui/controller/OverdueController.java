package ui.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import business.BookCopy;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class OverdueController {
	@FXML
	private TextField txtIsbn;
	@FXML
	private Label lblTitle;
	@FXML
	private Label lblIsbn;
	@FXML
	private Label lblMsg;
	@FXML 
	private ListView<String> ListViewOverDueBook;

	@FXML
	protected void getOverdue(ActionEvent event) {
		ListView<String> list = ListViewOverDueBook;
		ObservableList<String> items = FXCollections.observableArrayList();
	
		SystemController sc = new SystemController();
		try {
			HashMap<LibraryMember, List<BookCopy>> dueRecords = sc.getOverDueBooks(txtIsbn.getText());
			for(List<BookCopy> dueCopies : dueRecords.values()){				
				LibraryMember member = null;
				for (Entry<LibraryMember, List<BookCopy>> entry : dueRecords.entrySet()) {
					if (Objects.equals(dueCopies, entry.getValue())) {
						member = entry.getKey();						
						break;
					}
				}
				List<CheckoutRecordEntry> entries = member.getRecord().getEntries();
				for(CheckoutRecordEntry entry : entries){
					for(BookCopy dueCopy : dueCopies)
					if(entry.getBookCopy().equals(dueCopy)){
						String item = "Member Name: " + member.getFirstName() + " " + member.getLastName() + "\n";
						item += "Book Title: " + dueCopy.getBook().getTitle() + "\n";
						item += "Copy Number: " + dueCopy.getCopyNum() + "\n";
						item += "Checkout Date: " + entry.getCheckoutDate() + "\n";
						item += "Due Date: " + entry.getDueDate();
						items.add(item);
					}
				}
				
				
			}
			list.setItems(items);
			

		} catch (LibrarySystemException e) {
			lblTitle.setText(e.getMessage());
			lblTitle.setTextFill(Color.web("RED"));
		}


	}

}


