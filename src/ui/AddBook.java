package ui;

import java.io.IOException;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddBook extends Application {
    
	 @Override
	    public void start(Stage stage) throws  Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("FxmlAddBook.fxml"));
	        
	        stage.setTitle("AddBook");
	        Scene scene =new Scene(root, 1028, 800);
	        stage.setScene(scene);
	        // scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	        stage.show();
	        
	    }
	    
	    public static void main(String[] args) {
	        Application.launch(AddBook.class, args);
	    }
}
