package ui.controller;
 import business.LoginException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
 
public class FXMLLoginController {
    @FXML private TextField txtUserName;
    @FXML private  PasswordField txtPassword; 
    @FXML private  Button btnSubmit; 
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event)  {
       // actiontarget.setText("Sign in button pressed");
    	
    		SystemController syscontroller = new SystemController();
    	    
			try {
				syscontroller.login(txtUserName.getText(), txtPassword.getText());
				//System.out.println(txtPassWord.getText());
				//launch();
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		//	System.out.println(txtUserName.getText());
        
    	
	
    }

}
