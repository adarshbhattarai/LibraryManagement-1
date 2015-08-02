package ui.controller;


import java.util.ArrayList;
import java.util.List;

import business.Address;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddLibraryMemberController {
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
	private Label msg;
	
	@FXML
	protected void handleSave(ActionEvent event){
		//System.out.println("member Added");
		SystemController syscontroller =new SystemController();
		try {
			Address memaddress=new Address(txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText());
			syscontroller.addNewMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(), memaddress);
		} catch (LibrarySystemException e) {
			//System.out.println(e.getMessage());
			msg.setText("Member already Exists.");
			msg.setTextFill(Color.web("#FF0000"));
		}
		msg.setText("Member Has Been Added..");
		msg.setTextFill(Color.web("#01993C"));
		txtMemberId.clear();
		txtFirstName.clear();
		txtLastName.clear();
		txtStreet.clear();
		txtCity.clear();
		txtState.clear();
		txtZip.clear();
		txtPhone.clear();
	}
	
}
