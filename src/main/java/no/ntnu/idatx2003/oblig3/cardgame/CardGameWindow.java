package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CardGameWindow extends Application{

  private HashMap<String, PlayingCard> playingCards;

  public HashMap<String, PlayingCard> fillHashMap() {
    char[] signs = {'H', 'D', 'C', 'S'};
    int deckSize = 52;
    String key;
    for (int i = 0; i < signs.length; i++) {
      for (int j = 0; j < deckSize; j++) {
        key = String.format("%s%d", signs[i], j);
      }
    }
    return null;
  }
  @Override
  public void start(Stage stage) throws Exception {
    BorderPane rootNode = new BorderPane();

    FlowPane cardView = new FlowPane();
    GridPane gridNode1 = new GridPane();
    gridNode1.setPadding(new Insets(10,10,10,10));
    GridPane gridNode2 = new GridPane();
    gridNode2.setPadding(new Insets(10,10,10,10));

    Image c13 = new Image("/images/playingCardsSizeStandard/c13.png");
    ImageView imageView1 = new ImageView();
    imageView1.setImage(c13);
    Image c12 = new Image("/images/playingCardsSizeSmall/c13.png");
    ImageView imageView2 = new ImageView();
    imageView2.setImage(c12);

    rootNode.setCenter(cardView);
    rootNode.setRight(gridNode1);
    rootNode.setBottom(gridNode2);

    cardView.getChildren().addAll(imageView1, imageView2);

    Scene scene = new Scene(rootNode, 300, 200);

    stage.setScene(scene);
    stage.setTitle("Playing card game");

    stage.show();
  }

  public static void appMain(String[] args) {
    launch();
  }
}
