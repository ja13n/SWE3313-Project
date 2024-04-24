package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

/**
 *
 **/

public class Main extends Application {
    private Scene createAccountScene;
    private Scene orderScene;
    private Scene loginPageScene;
    private Stage stage;

    private boolean thisloadingDock;

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        stage = primaryStage;
        loginPageScene = loginPage();
        createAccountScene = createAccountPage();
        orderScene = createOrderPage();
        stage.setScene(choicePage());
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
        Button backButton = new Button("Back");

        Label helloLabel = new Label("Hello There");
        helloLabel.setVisible(false); // Label is not visible initially
        gp.add(helloLabel, 1, 6);

        btn.setOnAction(e -> {
            String userNam = "Customer1";
            String password = "1234";

            if (userTextField.getText().equals(userNam) && pwBox.getText().equals(password)) {
                try {
                    switchScenes(createOrderPage());
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                Alert dialog = new Alert(AlertType.INFORMATION);
                dialog.setHeaderText(
                        "Login failed, please make sure you are typing in the right username and password.");
                Optional<ButtonType> result = dialog.showAndWait();
            }

        });

        btn2.setOnAction(e -> {
            switchScenes(createAccountScene);
        });

        backButton.setOnAction(e -> {
            switchScenes(choicePage());
        });

        HBox hb = new HBox(10);
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().add(btn);
        hb.getChildren().add(btn2);
        gp.add(hb, 1, 4);
        gp.add(btn2, 2, 4);
        gp.add(backButton, 2, 10);
        loginPageScene = new Scene(gp, 640, 400);
        return loginPageScene;
    }

    public Scene createAccountPage() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        Button btn = new Button("Back to login");
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
        box.setSpacing(10);
        gp.getChildren().add(box);
        createAccountScene = new Scene(gp, 640, 400);
        return createAccountScene;
    }

    public Scene createOrderPage() throws ClassNotFoundException {
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

        Label salesRepIdLabel = new Label("Item: <15 characters, alpha numeric>");
        TextField salesRepIdField = new TextField();
        gp.add(salesRepIdLabel, 0, 2);
        gp.add(salesRepIdField, 1, 2);

        Label deliveryRepIdLabel = new Label("Quantity: <15 characters, alpha numeric>");
        TextField deliveryRepIdField = new TextField();
        gp.add(deliveryRepIdLabel, 0, 3);
        gp.add(deliveryRepIdField, 1, 3);

        Label itemNameLabel = new Label("Item Name");
        gp.add(itemNameLabel, 0, 4);

        Label quantityLabel = new Label("Quantity:");
        gp.add(quantityLabel, 1, 4);


        Item it = new Item();
        it.getItemsDB();
        for (int i = 0; i < 7; i++) {
            addOrderItem(gp, it.getItems().get(i).getItemName(), Integer.toString(it.getItems().get(i).getQuantity()));
        }

        HBox buttonsBox = new HBox();
        Button submitButton = new Button("Submit");
        Order order = new Order(new Item());
        Button backButton = new Button("Back to Login");
        backButton.setOnAction(e -> switchScenes(loginPageScene));
        buttonsBox.getChildren().addAll(submitButton, backButton);

        gp.add(buttonsBox, 2, 8, 2, 1);

        Scene orderScene = new Scene(gp, 640, 400);
        return orderScene;
    }

    public Scene choicePage() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.BASELINE_CENTER);

        gp.setHgap(10); // Set horizontal gap
        gp.setVgap(10); // Set vertical gap
        gp.setPadding(new Insets(25, 25, 25, 25)); // Set padding

        Label choiceLabel = new Label("Please choose an option:");
        gp.add(choiceLabel, 2, 1);

        Button customerButton = new Button("Customer Page");
        Button salesButton = new Button("Sales Personnel");

        HBox hb = new HBox(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(customerButton);
        hb.getChildren().add(salesButton);
        gp.add(hb, 5, 4);
        gp.add(customerButton, 4, 2);
        gp.add(salesButton, 0, 2);

        customerButton.setOnAction(e -> {
            switchScenes(customerPage());
        });

        salesButton.setOnAction(e -> {
            switchScenes(loginPage());
        });

        Scene choicePage = new Scene(gp, 640, 400);
        return choicePage;

    }

    public Scene customerPage() {
        CustomerDatabase cd = new CustomerDatabase();

        ListView<String> myListView = new ListView<>();
        myListView.getItems().addAll(cd.printlistofCustomers());

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.BASELINE_CENTER);

        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));

        Button addCustomerButton = new Button("Add Customer");

        Label companyNameLabel = new Label("Company Name: ");
        TextField companyNameField = new TextField();

        Label deliveryHoursLabel = new Label("Delivery Hours: ");
        TextField deliveryHoursField = new TextField();

        Label emailLabel = new Label("Email: ");
        TextField emailField = new TextField();

        Label phoneNumberLabel = new Label("Phone Number: ");
        TextField phoneNumberField = new TextField();

        Label loadingDockLabel = new Label("Loading Dock Capable:");

        final ToggleGroup loadingDockGroup = new ToggleGroup();
        RadioButton trueRB = new RadioButton("Yes");
        RadioButton falseRB = new RadioButton("No");
        trueRB.setToggleGroup(loadingDockGroup);
        falseRB.setToggleGroup(loadingDockGroup);

        gp.add(companyNameLabel, 0, 1);
        gp.add(companyNameField, 1, 1);
        gp.add(deliveryHoursLabel, 0, 2);
        gp.add(deliveryHoursField, 1, 2);
        gp.add(emailLabel, 0, 3);
        gp.add(emailField, 1, 3);
        gp.add(phoneNumberLabel, 0, 4);
        gp.add(phoneNumberField, 1, 4);
        gp.add(loadingDockLabel, 0, 5);
        gp.add(trueRB, 0, 6);
        gp.add(falseRB, 1, 6);

        addCustomerButton.setOnAction(e -> {
            String companyName = companyNameField.getText();
            String deliveryHours = deliveryHoursField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            boolean loadingDock = trueRB.isSelected();

            ContactInformation contactInfo = new ContactInformation(email, phoneNumber);
            Customer customer = new Customer(cd.getNextCustomerId(), companyName, contactInfo, loadingDock,
                    deliveryHours);
            cd.addCustomer(customer);
            myListView.getItems().add(0, customer.toString());
        });

        gp.add(addCustomerButton, 0, 7);
        gp.add(myListView, 2, 1, 1, 7);

        Scene customerPage = new Scene(gp, 640, 400);
        return customerPage;
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