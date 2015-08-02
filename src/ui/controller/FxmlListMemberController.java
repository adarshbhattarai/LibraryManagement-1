package ui.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import business.Address;
import business.Author;
import business.LibraryMember;
import business.SystemController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FxmlListMemberController {
	@FXML private Button btn;
	protected void test(ActionEvent event) {
		System.out.println("hello");
	}
	
	@FXML private TableView<LibraryMember> tableViewMember;
	@FXML private TableColumn<LibraryMember, String> gridMemberId;
	@FXML private TableColumn<LibraryMember, String> gridFirstName;
	@FXML private TableColumn<LibraryMember, String> gridLastName;
	@FXML private TableColumn<LibraryMember, String> gridStreet;
	@FXML private TableColumn<LibraryMember, String> gridCity;
	@FXML private TableColumn<LibraryMember, String> gridState;
	@FXML private TableColumn<LibraryMember, String> gridZip;
	@FXML private TableColumn<LibraryMember, String> gridPhone;


	private ObservableList<LibraryMember> memDetails;
	public void initialize() {
		HashMap<String , LibraryMember> mp = new HashMap<>();
		SystemController sc = new SystemController();
		mp=sc.getAllMembers();
		memDetails = FXCollections.observableArrayList();
		for(LibraryMember member : mp.values()){
			memDetails.add(member);
		}
		
		tableViewMember.setItems(memDetails);
		
		gridMemberId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMemberId()));
		gridFirstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
		gridLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
		gridStreet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getStreet()));
		gridCity.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getCity()));
		gridState.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getState()));
		gridZip.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getZip()));
		gridPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelephone()));
	
	}
	

}
