package ui;

import java.io.Serializable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddExistingBook extends Application  implements Serializable {
    
	 /**
	 * 
	 */
	private static final long serialVersionUID = -8125189632723674611L;

	@Override
	    public void start(Stage stage) throws  Exception {
	       Parent root = FXMLLoader.load(getClass().getResource("FxmlAddExistingBook.fxml"));
	        
	        stage.setTitle("AddBook");
	        Scene scene =new Scene(root, 510, 400);
	        stage.setScene(scene);
	        stage.show();
	        
	    }
	
	public static void main(String[] args) {
	        Application.launch(AddExistingBook.class, args);
	    }
		

	    
	
}
