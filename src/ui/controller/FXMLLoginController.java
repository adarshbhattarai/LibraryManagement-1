package ui.controller;
import business.SystemController;
import dataaccess.Auth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.LibSysMain;


 
public class FXMLLoginController {
    @FXML private TextField txtUserName;
    @FXML private  PasswordField txtPassword; 
    @FXML private  Button btnSubmit; 
    @FXML public static Auth role;
    @FXML private Label errmsg;
    
    public static Auth getRole() {
		return role;
	}
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event)  {
    		SystemController syscontroller = new SystemController();
    	    
			try {
				syscontroller.login(txtUserName.getText(), txtPassword.getText());
				if(SystemController.currentAuth.equals(Auth.LIBRARIAN)){
					handleDashBoard(event,Auth.LIBRARIAN);}
				else if (SystemController.currentAuth.equals(Auth.ADMIN)) {
					handleDashBoard(event,Auth.ADMIN);
				}
				else if(SystemController.currentAuth.equals(Auth.BOTH)){
					handleDashBoard(event,Auth.BOTH);
				}
				} catch (Exception e) {
				// TODO Auto-generated catch block
				
					errmsg.setText(e.getMessage());
				//e.printStackTrace();
			}
	    }


	private void handleDashBoard(ActionEvent event, Auth role) {
		FXMLLoginController.role=role;
    	LibSysMain main = new  LibSysMain();
		
   	 	Node  source = (Node)  event.getSource();
		Stage stage  = (Stage) source.getScene().getWindow();
		stage.close();
		main.start(new Stage());
		
	}

}
