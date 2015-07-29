package ui.controller;

import business.Address;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LibraryMemberController {
	@FXML
	private TextField txtMemberId;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtStreet;
	@FXML
	private TextField txtCity;
	@FXML
	private TextField txtZip;
	@FXML
	private TextField txtPhone;

	@FXML
	private Button btnSave;
	@FXML
	private TextField txtState;
	
	@FXML
	protected void handleSave(ActionEvent event){
		//SystemController sysCont=new SystemController();
		//Address address=new Address(txtStreet.getText(),txtCity.getText(),txtState.getText(),txtZip.getText());
		//sysCont.addNewMember(txtMemberId.getText(),txtFirstName.getText(),txtPhone.getText(),address);
	}
	
}
