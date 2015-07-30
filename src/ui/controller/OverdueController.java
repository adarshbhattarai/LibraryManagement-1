package ui.controller;

import business.Book;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class OverdueController {
	@FXML
	private TextField txtISBN;
	@FXML
	private TableColumn<Book, String> gridCopy;
	@FXML
	private TableColumn<Book, String> grdiCheckOutLength;
	@FXML
	private TableColumn<Book, String> gridIsbn;
	@FXML
	private TableColumn<Book, String> gridTitle;
}
