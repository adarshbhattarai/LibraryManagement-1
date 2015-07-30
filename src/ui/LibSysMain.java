package ui;
import dataaccess.Auth;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.controller.FXMLLoginController;

public class LibSysMain extends Application  {
	private AnchorPane Acnhor;
	
    public static void main(String[] args) {
        Application.launch(args);
    }
    

    
    @Override
    public void start(Stage primaryStage) {
       
        
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");
        MenuItem addBook = new MenuItem("Add Book");
        MenuItem addExistingBook = new MenuItem("Add Existing Book");
        MenuItem addMemebr = new MenuItem("Add New Member");
        MenuItem CheckOutBook = new MenuItem("Check Out Book");
        menu.getItems().add(addBook);
        menu.getItems().add(addExistingBook);
        menu.getItems().add(addMemebr);
        menu.getItems().add(CheckOutBook);
        
        if(FXMLLoginController.getRole().equals(Auth.LIBRARIAN)){
        	addBook.setDisable(true);
        }
      
       
     //   Pane pane1 = new Pane();
        
        menuBar.getMenus().add(menu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.setTitle("Library Mgmt");
        Group root = new Group();
       
        
        Scene scene = new Scene(root, 1028, 800);
        
        root.getChildren().add(menuBar); 
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
      
        addBook.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {
        	  AddBook main = new  AddBook();
      		try {
    			main.start(new Stage());
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
          }
        });
        
        
        addExistingBook.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	AddExistingBook main = new  AddExistingBook();
        		try {
      			main.start(new Stage());
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        addMemebr.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	AddMember main = new  AddMember();
        		try {
      			main.start(new Stage());
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        
    }
}