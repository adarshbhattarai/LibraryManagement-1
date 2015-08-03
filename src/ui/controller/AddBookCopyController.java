package ui.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.Book;
import business.LibrarySystemException;
import business.SystemController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AddBookCopyController {
	@FXML
	private TextField txtIsbn;
	@FXML
	private Button btnSearch;
	@FXML
	private TableView<Book> tableBookLoader;
	@FXML
	private TextField txtNoOfCopy;
	@FXML
	private Button btnAdd;
	@FXML
	private TableColumn<Book, String> gridCopy;
	@FXML
	private TableColumn<Book, String> grdiCheckOutLength;
	@FXML
	private TableColumn<Book, String> gridIsbn;
	@FXML
	private TableColumn<Book, String> gridTitle;

	Book bookselected;
	@FXML
	private Label lblMsg;

	private ObservableList<Book> bookDetails;
	// private List<Book> booktoadd = new ArrayList<>();
	SystemController sc = new SystemController();

	@FXML
	protected void SearchBookFromISBN(ActionEvent event) {
		lblMsg.setText("");
		txtNoOfCopy.clear();
		bookDetails = FXCollections.observableArrayList();
		bookDetails.clear();

		Book book = sc.searchBook(txtIsbn.getText());
		if (book == null) {
			try {
				throw new LibrarySystemException("No book found");
			} catch (LibrarySystemException e) {
				lblMsg.setText(e.getMessage());
				lblMsg.setTextFill(Color.RED);
			}
		} else {
			bookDetails.add(book);
			// booktoadd.add(book);
			tableBookLoader.setItems(bookDetails);
			lblMsg.setText("Book found.. please select book and insert copy number");
			lblMsg.setTextFill(Color.RED);
		}

	}

	@FXML
	protected void AddBookCopy(ActionEvent event) {
		// System.out.println("sa");
		lblMsg.setText("");
		bookselected = tableBookLoader.getSelectionModel().getSelectedItem();
		if (bookselected == null) {
			lblMsg.setText("Please select a row.");
			lblMsg.setTextFill(Color.RED);
		} else {

			try {
				int copies = Integer.parseInt(txtNoOfCopy.getText());
				while (copies != 0) {
					sc.addBookCopy(bookselected.getIsbn());
					--copies;
				}
				lblMsg.setText("Book Copy Has Been Added...");
				lblMsg.setFont(Font.font("Verdana", 14));
				lblMsg.setTextFill(Color.GREEN);				
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				lblMsg.setText("Please insert a number value");
				lblMsg.setFont(Font.font("Verdana", 14));
				lblMsg.setTextFill(Color.RED);
			} catch (LibrarySystemException e) {
				// TODO Auto-generated catch block
				lblMsg.setText(e.getMessage());
				lblMsg.setFont(Font.font("Verdana", 14));
				lblMsg.setTextFill(Color.RED);
			}

		}
	}

	@FXML
	private void initialize() {

		gridTitle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
		gridIsbn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIsbn()));
		grdiCheckOutLength.setCellValueFactory(
				cellData -> new SimpleStringProperty("" + cellData.getValue().getMaxCheckoutLength()));
		gridCopy.setCellValueFactory(cellData -> new SimpleStringProperty("" + cellData.getValue().getNumCopies()));

	}

}
