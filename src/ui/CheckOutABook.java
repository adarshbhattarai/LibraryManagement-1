package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CheckOutABook extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
	        
	        stage.setTitle("CheckOutABook");
	        stage.setScene(new Scene(root, 600, 480));
	        stage.show();
	    }
	    
	  /*  public static void main(String[] args) {
	        Application.launch(CheckOutABook.class, args);
	    }*/

}
