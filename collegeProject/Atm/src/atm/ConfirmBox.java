/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author mahmoudezzat
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author mahmoudezzat
 */
public class ConfirmBox {
    
    static boolean answer;
    
    
    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label label = new Label();
        label.setText(message);
        
        //create two buttons
        Button buttonYes = new Button("Yes");
        Button buttonNo = new Button("No");
        
        buttonYes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        
        buttonNo.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttonYes, buttonNo);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        
        return answer;
        
    }
}
