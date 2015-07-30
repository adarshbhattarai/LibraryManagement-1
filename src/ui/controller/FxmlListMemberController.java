package ui.controller;

import business.Address;
import business.Author;
import business.LibraryMember;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FxmlListMemberController {
	@FXML private TableView<Author> tableViewMember;
	@FXML private TableColumn<Author, String> gridMemberId;
	@FXML private TableColumn<Author, String> gridFirstName;
	@FXML private TableColumn<Author, String> gridLastName;
	@FXML private TableColumn<Author, String> gridStreet;
	@FXML private TableColumn<Author, String> gridCity;
	@FXML private TableColumn<Author, String> gridState;
	@FXML private TableColumn<Author, String> gridZip;
	@FXML private TableColumn<Author, String> gridPhone;
	
	private ObservableList<Author> memDetails = FXCollections.observableArrayList();
	//private ObservableList<LibraryMember> memAddDetails = FXCollections.observableArrayList();
	
	
	
	private void initialize() {
	//	memDetails.add();
		tableViewMember.setItems(memDetails);
	/*	
		gridMemberId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBio()));
		gridFirstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
		gridLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
		gridStreet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStr));
		gridStreet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getStreet()));
		gridCity.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getCity()));
		gridState.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getState()));
		gridZip.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getZip()));
		gridPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getZip()));
*/
	}
	

}
