package ui.controller;

import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import business.LibrarySystemException;
import business.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CheckoutController {
	@FXML
	private TextField txtMemberId;
	@FXML
	private TextField txtIsbn;
	@FXML
	private Label lblTitle;
	@FXML
	private Label lblCopyNumber;
	@FXML
	private Label lblCheckoutDate;
	@FXML
	private Label lblDueDate;
	@FXML
	private Label lblMsg;
	
	
	private ObservableList<CheckoutRecord> checkoutRecords;
	
	@FXML
	protected void CheckoutBook(ActionEvent event) {
		SystemController sc = new SystemController();
		try {
			CheckoutRecordEntry entry = sc.checkoutBook(txtMemberId.getText(), txtIsbn.getText());
			lblTitle.setText(entry.getBookCopy().getBook().getTitle());
			lblCopyNumber.setText(""+entry.getBookCopy().getCopyNum());
			lblCheckoutDate.setText(entry.getCheckoutDate().toString());
			lblDueDate.setText(entry.getDueDate().toString());
			lblMsg.setText("The checkout is successfull.");
			txtMemberId.setText("");
			txtIsbn.setText("");
		} catch (LibrarySystemException e) {
			lblMsg.setText(e.getMessage());
			lblTitle.setText("");
			lblCopyNumber.setText("");
			lblCheckoutDate.setText("");
			lblDueDate.setText("");
			e.printStackTrace();
		}

	}
	
	
}
