package ui;

import java.io.IOException;
import java.io.Serializable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddBook extends Application  implements Serializable {
    
	 /**
	 * 
	 */
	private static final long serialVersionUID = -8125189632723674611L;

	@Override
	    public void start(Stage stage) throws  Exception {
	       Parent root = FXMLLoader.load(getClass().getResource("FxmlAddBook.fxml"));
	        
	        stage.setTitle("AddBook");
	        Scene scene =new Scene(root, 800, 620);
	        stage.setScene(scene);
	        stage.show();
	        
	    }
	
		

	    
	
}
