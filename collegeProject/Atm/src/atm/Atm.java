/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 *
 * @author mahmoudezzat
 */
public class Atm extends Application{
    Stage window;
    Scene sceneLogin,sceneMainMenu,sceneDeposite,sceneWithDraw;
    Balance balance = new Balance();
    SceneSelector scene = new SceneSelector();
    public int i = -1;
    
    @Override
    public void start(Stage primaryStage) {
        
        window = primaryStage;
        //first window <<LOGIN>>
        TextField cardID = new TextField();
        
        Button btnLogin = new Button();
        btnLogin.setText("Log In");
        
        btnLogin.setOnAction(e -> {
            System.out.println("id: "+cardID.getText());
            boolean ok = false;
            if (cardID.getText().equals(balance.getID())) ok = true;
            else ok = false;
            
            if (ok == true) {
                window.setScene(sceneMainMenu);
                
            }
            else AlertBox.display("Login", "invalid ID");
            cardID.clear();
        });
        VBox layoutLogin = new VBox(10);
        layoutLogin.setPadding(new Insets(20, 20, 20, 20));
        layoutLogin.getChildren().addAll(cardID, btnLogin);
        
        sceneLogin = new Scene(layoutLogin, 300, 300);
        //---------------------------------------------------------------------------
        
        
        //second window <<mainMenu>>
        
        //buttons of main menu
        Button btnDeposite = new Button("Deposite");
        Button btnWithDraw = new Button("WithDraw");
        Button btnShowBalance = new Button("Show Balance");
        Button btnLogout = new Button("Logout");
        
        Button next = new Button("next");
        Button previous = new Button("previous");
        Label label = new Label();
        
        // functionality of buttons of main menu
        btnDeposite.setOnAction(e -> scene.selectScene(1,sceneMainMenu,balance,window));
        btnWithDraw.setOnAction(e -> scene.selectScene(2,sceneMainMenu,balance,window));
        btnLogout.setOnAction(e -> window.setScene(sceneLogin));
        btnShowBalance.setOnAction(e ->{
            AlertBox.display("balance", Double.toString(balance.getBalance()));
            System.out.println(balance.getBalance());
        }
        );
        
        
        
        //testing
        System.out.println("index gui: "+i);
        System.out.println("index logic"+balance.getFinalIdx());
        
        
        next.setOnAction(e -> {
            System.out.println("index gui: "+i);
            System.out.println("index logic"+balance.getFinalIdx());
            if (i == balance.getFinalIdx() - 1) label.setText("nothing to show");
            else if (balance.getHistory(i+1) < 0) {
                i++;
                
                System.out.println("you withdraw: "+(-1 * balance.getHistory(i)));
                //testing
                label.setText("you withdraw: "+(-1 * balance.getHistory(i)));
            } else {
                i++;
                System.out.println("you deposited: "+(1 * balance.getHistory(i)));
                //testing
                label.setText("you deposited: "+(1 * balance.getHistory(i)));
            }
            
        });
        
        
        previous.setOnAction(e -> {
           
            if (i <= -1) label.setText("nothing to show");
            else if (balance.getHistory(i) < 0) {
                
                System.out.println("you withdraw: "+(-1 * balance.getHistory(i)));
                //testing
                System.out.println("index gui: "+(i));
                System.out.println("index logic"+balance.getFinalIdx());
                label.setText("you withdraw: "+(-1 * balance.getHistory(i)));
                i = i - 1;
            }else {
                System.out.println("you deposited: "+(1 * balance.getHistory(i)));
                //testing
                System.out.println("index gui: "+(i));
                System.out.println("index logic"+balance.getFinalIdx());
                label.setText("you deposited: "+(1 * balance.getHistory(i)));
                i = i - 1;
            }
            
            
        });
        
        
        
        
        // making layout of main menu
        VBox layoutMainMenu = new VBox(10);
        layoutLogin.setPadding(new Insets(20, 20, 20, 20));
        layoutMainMenu.getChildren().addAll(btnDeposite,btnWithDraw,btnShowBalance,btnLogout,label,next,previous);
        sceneMainMenu = new Scene(layoutMainMenu, 300, 300);
        //---------------------------------------------------------------------------
        
        
        
        
        
        //code for primary stage.............................
        primaryStage.setTitle("ATM Machine");
        primaryStage.setScene(sceneLogin);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
