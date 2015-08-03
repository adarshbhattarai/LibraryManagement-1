package ui;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;

import dataaccess.Auth;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import ui.controller.LoginController;

public class LibSysMain extends Application  {
	//private AnchorPane Acnhor;
	
    public static void main(String[] args) {
        Application.launch(args);
    }
    

    
    @Override
    public void start(Stage primaryStage) {
       
    	
        MenuBar menuBar = new MenuBar();
        Pane pane = new Pane();
        Menu menu = new Menu("Book");
        Menu menuMember = new Menu("Member");
        Menu console = new Menu("Print");
        Menu logout = new Menu("Logout");
       
        Menu session = new Menu();
        
        
        
        Label label = new Label();
        Label lblsession = new Label();
        lblsession.setTextFill(Color.web("#00AB92"));
      
        
        
   //     label.set
        label.setTextFill(Color.web("#FFFFFF"));
        Image image = new Image(getClass().getResourceAsStream("bg.png"));
        label.setGraphic(new ImageView(image));
        
        label.setAlignment(Pos.TOP_CENTER);
        lblsession.setAlignment(Pos.TOP_CENTER);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(100);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        
        MenuItem addBook = new MenuItem("Add Book");
        MenuItem addExistingBook = new MenuItem("Add Book Copy");
        MenuItem addMemebr = new MenuItem("Add New Member");
        MenuItem listMemebr = new MenuItem("List Member");
      //  MenuItem overDue = new MenuItem("Overdue Publication");
        MenuItem checkout = new MenuItem("Checkout of Book");
        MenuItem print = new MenuItem("Print Checkout");
        MenuItem mnulogout = new MenuItem("Log Out");
        MenuItem overDew = new MenuItem("Find Overdue");
      
        
        menu.getItems().add(addBook);
        menu.getItems().add(addExistingBook);
     //   menu.getItems().add(overDue);
        menu.getItems().add(checkout);
        menu.getItems().add(overDew);
       
        
        console.getItems().add(print);
        
        menuMember.getItems().add(addMemebr);
        menuMember.getItems().add(listMemebr);
        
        logout.getItems().add(mnulogout);
        
        
        
        
      
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(menuMember);
        menuBar.getMenus().add(console);
        menuBar.getMenus().add(session);
        menuBar.getMenus().add(logout);
        
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.setTitle("Library Mgmt");
        
        Group root = new Group();
        
        
        if(LoginController.getRole().equals(Auth.LIBRARIAN)){
        	addBook.setDisable(true);
        	addMemebr.setDisable(true);  
        	listMemebr.setDisable(true);      	
        	addExistingBook.setDisable(true);
        	lblsession.setText("You are Logged in as Librarian");
        	}
        else if(LoginController.getRole().equals(Auth.ADMIN)){
        	//addBook.setDisable(true);
        	print.setDisable(true);
        	checkout.setDisable(true);
        	overDew.setDisable(true);
        	
        	lblsession.setText("You are Logged in as Admin");}
        else{
        	//addBook.setDisable(true);
        	lblsession.setText("You are Logged in as Full Admin");
        	}
        
        lblsession.setPadding(new Insets(50, 50, 50, 200));
    	lblsession.setFont(new Font(15));
        
       
        
        Scene scene = new Scene(root, 1100, 700,Color.WHITE);
        pane.getChildren().add(grid); 
        pane.getChildren().add(menuBar); 
        grid.add(label, 2, 1);
        grid.add(lblsession, 2, 0);
        root.getChildren().add(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        Stage childstage = new Stage();
        
        
        
        overDew.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
          	  Overdue main = new  Overdue();
        		try {
        			
      			main.start(childstage);
      			  		        
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        
        
        listMemebr.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
          	  ListMember main = new  ListMember();
        		try {
        			
      			main.start(childstage);
      			  		        
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        
        
        addBook.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {
        	  AddBook main = new  AddBook();
      		try {
      			
    			main.start(childstage);
    			  		        
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
          }
        });
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
          	  Login login = new  Login();
        		try {
        			
        		primaryStage.close();
        		childstage.close();
        		login.start(new Stage());
      			  		        
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
      			main.start(childstage);
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
      			main.start(childstage);
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
     /*   overDue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	Overdue main = new Overdue();
        		try {
      			main.start(childstage);
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });*/
        
        checkout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	CheckOutABook main = new CheckOutABook();
        		try {
      			main.start(childstage);
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
      			main.start(childstage);
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
            }
          });
        
        
    }
}