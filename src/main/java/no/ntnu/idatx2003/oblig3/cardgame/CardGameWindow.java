package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.event.Event;

public class CardGameWindow
    extends Application {

  public HashMap<String, Image> prepareImageViewOfCards() {
    HashMap<String, Image> mapOfCardImages = new HashMap<>();
    DeckOfCards deckOfCards = new DeckOfCards();
    Image image;
    for (PlayingCard playingCard :
        deckOfCards.makeArrayListFromHashmap(deckOfCards.getDeckOfCards())) {
      image = new Image("/images/playingCardsSizeStandard/"
          + playingCard.getAsString() + ".png");
      mapOfCardImages.put(playingCard.getAsString(), image);
    }
    return mapOfCardImages;
  }

  @Override
  public void start(Stage stage) throws Exception {
    DeckOfCards deckOfCards = new DeckOfCards();
    HashMap<String, Image> cardImages = prepareImageViewOfCards();

    BorderPane rootNode = new BorderPane();

    FlowPane cardView = new FlowPane();
    GridPane playArea = new GridPane();
    playArea.setPadding(new Insets(10,10,10,10));
    GridPane infoArea = new GridPane();
    infoArea.setPadding(new Insets(10,10,10,10));

    rootNode.setCenter(cardView);
    rootNode.setRight(playArea);
    rootNode.setBottom(infoArea);

    Button dealCardsButton = new Button();
    dealCardsButton.setText("Deal cards");



    Image c12 = new Image("/images/playingCardsSizeSmall/c13.png");
    ImageView imageView2 = new ImageView();
    imageView2.setImage(c12);

    playArea.getChildren().add(dealCardsButton);

    Scene scene = new Scene(rootNode, 900, 600);

    stage.setScene(scene);
    stage.setTitle("Playing card game");

    dealCardsButton.setOnAction(actionEvent -> {
          System.out.println("dealHand button pressed");
          deckOfCards.dealHand(5);
          cardView.getChildren().removeAll();
          ImageView imageView = new ImageView();
          imageView.setImage(cardImages.get("h12"));
          cardView.getChildren().add(imageView);
          stage.setScene(scene);
          stage.show();
        }
    );

    stage.show();
  }

  public static void appMain(String[] args) {
    launch(args);
  }
}
