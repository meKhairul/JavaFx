/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailBox;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class LogIn extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("EmailBox");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label Email = new Label("Email:");
        grid.add(Email, 0, 2);

        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);
        
        Label batch = new Label("Batch :");
        grid.add(batch, 0, 3);
        ChoiceBox bal = new ChoiceBox();
        bal.getItems().addAll("BSSE","BSSE10","BSSE11","BSSE12");
        bal.setValue("BSSE");
        grid.add(bal, 1, 3);
        
        Label gender = new Label("Gender :");
        grid.add(gender, 0, 4);
        
        RadioButton rbtn = new RadioButton("Female");
        RadioButton rbtn1 = new RadioButton("Male");
        ToggleGroup grp = new ToggleGroup();
        rbtn.setToggleGroup(grp);
        rbtn1.setToggleGroup(grp);
        
        grid.add(rbtn, 1, 4);
        grid.add(rbtn1, 2, 4);
        
        Label about = new Label("About");
        grid.add(about, 0, 5);
        
        TextField text = new TextField();
        text.setPrefSize(50, 150);
        grid.add(text, 1, 5);
        
        Button lbtn = new Button("Clear");
        Button lbtn2 = new Button("Ok");
        Button lbtn3 = new Button("Cancel");
        
        lbtn.setOnAction((e) -> {
            text.clear();
            userTextField.clear();
            emailTextField.clear();
            bal.getSelectionModel().selectFirst();
            rbtn.setSelected(false);
            rbtn1.setSelected(false);
                });
        
        lbtn2.setOnAction((e) -> {
            RadioButton genderOutput = (RadioButton)grp.getSelectedToggle();
            String UserGender = genderOutput.getText();
        
            JOptionPane.showMessageDialog(null, "Name : " + userTextField.getText() + "\nEmail : " + emailTextField.getText() + "\nBatch : "
        + bal.getValue() + "\nGender : " + UserGender + "\nAbout : " + text.getText());
        });
        
        lbtn3.setOnAction(e -> System.exit(0));
        
        grid.add(lbtn, 1, 6);
        grid.add(lbtn2, 2, 6);
        grid.add(lbtn3, 3, 6);
        
        Scene scene = new Scene(grid, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
