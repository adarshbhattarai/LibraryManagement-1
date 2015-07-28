package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibrarySystemMain extends Application{
	private Parent root;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		root = FXMLLoader.load(getClass().getResource("LibrarySystemMain.fxml"));
        Scene scene = new Scene(root, 1028, 800);
	    stage.setScene(scene);
	  //  scene.getStylesheets().add(getClass().getResource("main_window.css").toExternalForm());
	    stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
