package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListMember extends Application {
	
    public void start(Stage stage) throws  Exception {
	       	Parent root = FXMLLoader.load(getClass().getResource("ListMember.fxml"));
	        stage.setTitle("ListMember");
	        Scene scene =new Scene(root, 650, 380);
	        stage.setScene(scene);
	        stage.show();
	        
	    }
   public static void main(String[] args) {
        Application.launch(ListMember.class, args);
        
    }
		

}
