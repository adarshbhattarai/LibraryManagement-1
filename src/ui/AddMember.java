package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddMember  extends Application{
	
	@Override
    public void start(Stage stage) throws  Exception {
       Parent root = FXMLLoader.load(getClass().getResource("AddLibraryMember.fxml"));
        
        stage.setTitle("AddMember");
        Scene scene =new Scene(root, 600, 420);
        stage.setScene(scene);
        stage.show();
        
    }

	

}
