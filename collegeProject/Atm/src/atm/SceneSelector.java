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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mahmoudezzat
 */
public class SceneSelector {
    
    
            
    public static void selectScene(int choice, Scene sceneMainMenu,Balance balance,Stage window) {
        
        window.addEventFilter(KeyEvent.ANY, KeyEvent::consume);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setVgap(10);
        grid.setHgap(10);
        
        // text field
        TextField textField = new TextField();
        textField.setPromptText("enter cash amount");
        GridPane.setConstraints(textField, 2, 1,2,1);
        
        //buttons
        Button btn1 = new Button("1");
        GridPane.setConstraints(btn1, 1, 2);
        btn1.setOnAction(e -> {
            textField.appendText("1");
            
        });
        
        Button btn2 = new Button("2");
        GridPane.setConstraints(btn2, 2, 2);
        btn2.setOnAction(e -> textField.appendText("2"));
        
        Button btn3 = new Button("3");
        GridPane.setConstraints(btn3, 3, 2);
        btn3.setOnAction(e -> textField.appendText("3"));
        
        Button btn4 = new Button("4");
        GridPane.setConstraints(btn4, 1, 3);
        btn4.setOnAction(e -> textField.appendText("4"));
        
        Button btn5 = new Button("5");
        GridPane.setConstraints(btn5, 2, 3);
        btn5.setOnAction(e -> textField.appendText("5"));
        
        Button btn6 = new Button("6");
        GridPane.setConstraints(btn6, 3, 3);
        btn6.setOnAction(e -> textField.appendText("6"));
        
        Button btn7 = new Button("7");
        GridPane.setConstraints(btn7, 1, 4);
        btn7.setOnAction(e -> textField.appendText("7"));
        
        Button btn8 = new Button("8");
        GridPane.setConstraints(btn8, 2, 4);
        btn8.setOnAction(e -> textField.appendText("8"));
        
        Button btn9 = new Button("9");
        GridPane.setConstraints(btn9, 3, 4);
        btn9.setOnAction(e -> textField.appendText("9"));
        
        Button btn0 = new Button("0");
        GridPane.setConstraints(btn0, 2, 5);
        btn0.setOnAction(e -> textField.appendText("0"));
        
        Button btnAccept = new Button("Enter");
        GridPane.setConstraints(btnAccept, 4, 2);
        btnAccept.setOnAction(e -> {
            boolean result = ConfirmBox.display("amount", "continue");
            double amount = Double.parseDouble(textField.getText());
            System.out.println(amount);
            System.out.println(result);
            if (result == true) {
                if (choice == 1){
                balance.deposite(amount);
                balance.setHistory(amount);
                System.out.println("idx logic increased by 1");
                AlertBox.display("good job", "Successful transaction!");
                window.setScene(sceneMainMenu);
                }  else {
                    if (amount > balance.getBalance()){
                        AlertBox.display("WithDraw", "withdraw amount greater than current balance");
                        textField.clear();
                    }
                    else {
                        balance.withDraw(amount);
                        balance.setHistory(-1 *amount);
                        AlertBox.display("good job", "Successful transaction!");
                        System.out.println("idx logic increased by 1");
                        window.setScene(sceneMainMenu);
                    }
                }
            }
            
        });
        
        
        Button btnBack = new Button("back");
        btnBack.setOnAction(e -> window.setScene(sceneMainMenu));
        GridPane.setConstraints(btnBack, 0, 10);
        
        Button btnDelete = new Button("delete");
        GridPane.setConstraints(btnDelete, 4, 4);
        btnDelete.setOnAction(e -> textField.deleteText(textField.getLength()-1,textField.getLength()));
        
        
    
        
        grid.getChildren().addAll(textField,btnBack,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAccept,btnDelete);
        Scene scene = new Scene(grid,300,300);
        
        window.setScene(scene);
        window.show();
        
    }
}
