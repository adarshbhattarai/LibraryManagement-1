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

public class FxmlAddExistingBookController {
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
	private List<Book> booktoadd = new ArrayList<>();
	SystemController sc = new SystemController();

	@FXML
	protected void SearchBookFromISBN(ActionEvent event) {
		bookDetails = FXCollections.observableArrayList();

		Book book = sc.searchBook(txtIsbn.getText());
		bookDetails.add(book);
		booktoadd.add(book);
		tableBookLoader.setItems(bookDetails);

	}

	@FXML
	protected void AddExistingBook(ActionEvent event) {
		// System.out.println("sa");
		bookselected = tableBookLoader.getSelectionModel().getSelectedItem();
		if (bookselected == null) {
			lblMsg.setText("Please select a row.");
			System.out.println("select a row");
		} else {
			int copies = Integer.parseInt(txtNoOfCopy.getText());
			try {
				while (copies != 0) {
					sc.addBookCopy(bookselected.getIsbn());
					--copies;
				}
			} catch (LibrarySystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
