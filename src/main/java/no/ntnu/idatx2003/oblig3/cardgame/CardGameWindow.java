package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CardGameWindow extends Application{
  @Override
  public void start(Stage stage) throws Exception {
    FlowPane rootNode = new FlowPane();
    Scene scene = new Scene(rootNode, 300, 200);

    stage.setScene(scene);
    stage.setTitle("Playing card game");

    stage.show();
  }

  public static void appMain(String[] args) {
    launch();
  }
}
