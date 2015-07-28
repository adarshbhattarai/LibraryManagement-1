package ui.controller;


import java.util.ArrayList;
import java.util.List;

import business.Address;
import business.Author;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FxmlAddBookController {
	
	@FXML private TextField txtFirstName;
	@FXML private TextField txtLastName;
	@FXML private TextField txtPhoneNum;
	@FXML private TextField txtCredentials;
	@FXML private TextField txtStreet; 
	@FXML private TextField txtCity;
	@FXML private TextField txtState;
	@FXML private TextField txtZip;
	@FXML private Button 	btnSaveAuthor;
	
	
	@FXML private TableView<Author> tblAuthorList;

	
	@FXML private TableColumn<Author, String> gridFirstName;
	@FXML private TableColumn<Author, String> gridLastName;
	@FXML private TableColumn<Author, String> gridPhone;
	@FXML private TableColumn<Author, String> gridCredentials;
	@FXML private TableColumn<Author, String> gridStreet;
	@FXML private TableColumn<Author, String> gridCity;
	@FXML private TableColumn<Author, String> gridState;
	@FXML private TableColumn<Author, String> gridZip;

	@FXML private TextField txtIsbn;
	@FXML private TextField txtBookTitle;
	@FXML private TextField txtMaxChkOutLength;
	@FXML private TextField txtNumberOfCopies;
	
	
	private ObservableList<Author> authDetails = FXCollections.observableArrayList();

	@FXML protected void  SaveAuthorToList(ActionEvent event){

		 Address address = new Address(txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText()); 
		 Author author = new Author(txtFirstName.getText(), txtLastName.getText(), txtPhoneNum.getText(), address,txtCredentials.getText());
		 authDetails.add(author);
		 
		 tblAuthorList.setItems(authDetails);
		 	
		 txtFirstName.clear();
		 	txtLastName.clear();
		 	txtPhoneNum.clear();
			txtCredentials.clear();
			txtStreet.clear();
			txtCity.clear();
			txtState.clear();
			txtZip.clear();
		 

		
		
	}
	
	
	@FXML
    private void initialize() {
		
	gridFirstName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getFirstName()));
	gridLastName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getLastName()));
	gridPhone.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTelephone()));
	gridCredentials.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getBio()));
	gridStreet.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress().getStreet()));
	gridCity.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress().getCity()));
	gridState.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress().getState()));
	gridZip.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAddress().getZip()));
				
	
		
	}
	
	

}
