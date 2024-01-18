//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.database;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private double x = 0.0;
    private Stage loginStage;
    private double y = 0.0;
    private static Stage stg;

    public HelloApplication() {
    }

    public void start(final Stage stage) throws IOException {
        stg = stage;
        Parent root = (Parent)FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                HelloApplication.this.x = event.getSceneX();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - HelloApplication.this.x);
            }
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("kfc");
        stage.setScene(scene);
        stage.show();
    }





    public static void main(String[] args) {
        launch(new String[0]);
    }
}
