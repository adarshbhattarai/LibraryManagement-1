package ui;
import dataaccess.Auth;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.controller.LoginController;

public class LibSysMain extends Application  {
	private AnchorPane Acnhor;
	
    public static void main(String[] args) {
        Application.launch(args);
    }
    

    
    @Override
    public void start(Stage primaryStage) {
       
    	Pane pane = new Pane();
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");
        MenuItem addBook = new MenuItem("Add Book");
        MenuItem addExistingBook = new MenuItem("Add Existing Book");
        MenuItem addMemebr = new MenuItem("Add New Member");
        //MenuItem CheckOutBook = new MenuItem("Check Out Book");
        MenuItem overDue = new MenuItem("Overdue Publication");
        MenuItem checkout = new MenuItem("Checkout of Book");
        MenuItem print = new MenuItem("Print Checkout");
        menu.getItems().add(addBook);
        menu.getItems().add(addExistingBook);
        menu.getItems().add(addMemebr);
        //menu.getItems().add(CheckOutBook);
        menu.getItems().add(overDue);
        menu.getItems().add(checkout);
        menu.getItems().add(print);
        
        if(LoginController.getRole().equals(Auth.LIBRARIAN)){
        	addBook.setDisable(true);
        }
      
       
     //   Pane pane1 = new Pane();
        
        menuBar.getMenus().add(menu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.setTitle("Library Mgmt");
        Group root = new Group();
       
        
        Scene scene = new Scene(root, 900, 700);
        pane.getChildren().add(menuBar); 
        root.getChildren().add(menuBar); 
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
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
            	AddBookCopy main = new  AddBookCopy();
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
        
        overDue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	Overdue main = new Overdue();
        		try {
      			main.start(new Stage());
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        checkout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	CheckOutABook main = new CheckOutABook();
        		try {
      			main.start(new Stage());
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        print.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	Printcheckout main = new Printcheckout();
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