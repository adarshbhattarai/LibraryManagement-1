package ui;

import java.io.IOException;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Login extends Application {
    
	 @Override
	    public void start(Stage stage) throws  Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("JAVAFX_LOGIN.fxml"));
	        
	        stage.setTitle("Login");
	        Scene scene =new Scene(root, 400, 180);
	        stage.setScene(scene);
	        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	        stage.show();
	        
	    }
	    
	    public static void main(String[] args) {
	        Application.launch(Login.class, args);
	    }
}
