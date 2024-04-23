package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * 
 **/

public class Main extends Application {
    private Stage createAccountStage;
    private Scene createAccountScene;
    private Scene orderScene;
    private Stage loginPageStage;
    private Scene loginPageScene;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        loginPageScene = loginPage();
        createAccountScene = createAccountPage();
        orderScene = createOrderPage();
        stage.setScene(loginPageScene);
        stage.show();
    }

    public Scene loginPage() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER); // setting the alignment of the grid to the center of the screen
        gp.setHgap(10); // Setting the horizontal gap of the grid.
        gp.setVgap(10); // Setting the vertical gap of the grid.
        gp.setPadding(new Insets(25, 25, 25, 25)); // Creating padding for the grid to make it look even more centered
        // Set scene of layout
        Label userName = new Label("User Name or Customer ID:");
        gp.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gp.add(userTextField, 1, 1);
        Label pw = new Label("Password:");
        gp.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gp.add(pwBox, 1, 2);

        Button btn = new Button("Log In");
        Button btn2 = new Button("Create Account");
        Button testButton = new Button("Joel Test");

        Label helloLabel = new Label("Hello There");
        helloLabel.setVisible(false); // Label is not visible initially
        gp.add(helloLabel, 1, 6);

        btn.setOnAction(e -> {
            helloLabel.setVisible(true); // Only make the label visible on button click
        });

        btn2.setOnAction(e -> {
            switchScenes(createAccountScene);
        });

        testButton.setOnAction(e -> {
            switchScenes(orderScene);
        });

        HBox hb = new HBox(10);
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().add(btn);
        hb.getChildren().add(btn2);
        gp.add(hb, 1, 4);
        gp.add(btn2, 2, 4);
        gp.add(testButton, 1, 9);
        createAccountScene = new Scene(gp, 640, 400);
        return createAccountScene;
    }

    public Scene createAccountPage() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        Button btn = new Button("Login");
        btn.setOnAction(e -> switchScenes(loginPage()));
        Button btn2 = new Button("Create Account:");
        gp.add(btn, 2, 6);
        gp.add(btn2, 2, 8);
        VBox box = new VBox();

        Label companyName = new Label("Company Name:");
        TextField companyNameField = new TextField();

        Label address = new Label("Address:");
        TextField addressField = new TextField();

        Label loadingDock = new Label("Loading Dock Capable:");
        CheckBox loadingDockCheckbox = new CheckBox();

        Label deliveryHours = new Label("Delivery Hours:");
        TextField deliveryHoursField = new TextField();

        box.getChildren().addAll(companyName, companyNameField, address, addressField, loadingDock, loadingDockCheckbox,
                deliveryHours, deliveryHoursField);
        box.setPadding(new Insets(20, 20, 20, 20));
        box.setSpacing(30);
        gp.getChildren().add(box);
        createAccountScene = new Scene(gp, 640, 400);
        return createAccountScene;
    }

    public Scene createOrderPage() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        gp.setHgap(10); // Set horizontal gap
        gp.setVgap(10); // Set vertical gap
        gp.setPadding(new Insets(25, 25, 25, 25)); // Set padding

        // Labels and TextFields
        Label accountIdLabel = new Label("Account ID#: <15 characters, alpha numeric>");
        TextField accountIdField = new TextField();
        gp.add(accountIdLabel, 0, 0);
        gp.add(accountIdField, 1, 0);

        Label deliveryDateLabel = new Label("Delivery Date: <mm/dd/yyyy>");
        TextField deliveryDateField = new TextField();
        gp.add(deliveryDateLabel, 0, 1);
        gp.add(deliveryDateField, 1, 1);

        Label salesRepIdLabel = new Label("Sales Rep ID: <15 characters, alpha numeric>");
        TextField salesRepIdField = new TextField();
        gp.add(salesRepIdLabel, 0, 2);
        gp.add(salesRepIdField, 1, 2);

        Label deliveryRepIdLabel = new Label("Delivery Rep ID: <15 characters, alpha numeric>");
        TextField deliveryRepIdField = new TextField();
        gp.add(deliveryRepIdLabel, 0, 3);
        gp.add(deliveryRepIdField, 1, 3);

        Label itemNameLabel = new Label("Item Name");
        gp.add(itemNameLabel, 0, 4);

        Label quantityLabel = new Label("Quantity:");
        gp.add(quantityLabel, 1, 4);

        addOrderItem(gp, "ALG WHITE BEER 12/19.2C", "15");
        addOrderItem(gp, "ALG WHITE BEER 4/6BTL", "25");
        addOrderItem(gp, "ALG WHITE BEER 2/12 CANS", "30");

        HBox buttonsBox = new HBox(10);
        Button submitButton = new Button("Submit Order");
        Button backButton = new Button("Back to Login");
        backButton.setOnAction(e -> switchScenes(loginPageScene));
        buttonsBox.getChildren().addAll(submitButton, backButton);

        gp.add(buttonsBox, 0, 8, 4, 1);

        Scene orderScene = new Scene(gp, 640, 400);
        return orderScene;
    }

    private void addOrderItem(GridPane gp, String itemName, String quantity) {
        Label itemNameLabel = new Label(itemName);
        Label quantityLabel = new Label(quantity);
        gp.add(itemNameLabel, 0, gp.getRowCount());
        gp.add(quantityLabel, 1, gp.getRowCount() - 1);
    }

    public void switchScenes(Scene scene) {
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    } // end main

} // end class
