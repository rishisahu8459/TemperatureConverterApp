package com.example.demo2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){

launch(args);

    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        Pane rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0 ,menuBar);






        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.show();



    }
    private MenuBar createMenu(){
        Menu fileMenu = new Menu("File");

        MenuItem newMenuitem = new MenuItem("New");
        MenuItem aboutMenuitem = new MenuItem("about");
        MenuItem saveMenuitem = new MenuItem("save");
        MenuItem closeMenuitem = new MenuItem("close");
        SeparatorMenuItem separator = new SeparatorMenuItem();

        fileMenu.getItems().addAll(newMenuitem,aboutMenuitem,separator,saveMenuitem,closeMenuitem);
        newMenuitem.setOnAction(event -> {
            System.out.println("new");


        });
        aboutMenuitem.setOnAction(event -> aboutMenu());
        closeMenuitem.setOnAction(event -> {
           // Platform.exit();
            System.exit(0);
            
        });
        Menu editMenu = new Menu("Edit");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu);
        return menuBar;


    }

    private void aboutMenu() {
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutAlert.setTitle("Open");
        aboutAlert.setHeaderText("about the app");
        aboutAlert.setContentText(" Temperature Conversion app Created by Rishabh Sahu ");

        aboutAlert.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
