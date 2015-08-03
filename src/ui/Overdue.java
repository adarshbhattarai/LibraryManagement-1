package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Overdue extends Application {
    
	 @Override
	    public void start(Stage stage) throws  Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("Overdue.fxml"));
	        
	        stage.setTitle("Overdue");
	        Scene scene =new Scene(root, 600, 392);
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	        
	    }
	    
	    public static void main(String[] args) {
	        Application.launch(Overdue.class, args);
	    }
}