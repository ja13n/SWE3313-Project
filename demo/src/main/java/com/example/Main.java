package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Setting up the grid for the fields.
        GridPane g = new GridPane();
        g.setAlignment(Pos.CENTER); // setting the alignment of the grid to the center of the screen
        g.setHgap(10); // Setting the horizontal gap of the grid.
        g.setVgap(10); //Setting the vertical gap of the grid.
        g.setPadding(new Insets(25, 25, 25, 25)); // Creating padding for the grid to make it look even more centered
        // Set scene of laya
        Scene s = new Scene(loginPage(g), 640, 400);
        stage.setScene(s);
        stage.show();
    }


    public GridPane loginPage(GridPane gp) {
        VBox b = new VBox();
        Label userName = new Label("User Name:");
        gp.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gp.add(userTextField, 1, 1);
        Label pw = new Label("Password:");
        gp.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gp.add(pwBox, 1, 2);
        return gp;
    }

    public static void main(String[] args) {
        launch();
    }

}
