package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.Event;

public class CardGameWindow
    extends Application {

    PlayingCardHand dealtHand;


  public HashMap<String, Image> prepareImagesFromListOfCards() {
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
    HashMap<String, Image> cardImages = prepareImagesFromListOfCards();

    BorderPane rootNode = new BorderPane();

    FlowPane cardView = new FlowPane();
    VBox playArea = new VBox();
    playArea.setPadding(new Insets(10,10,10,10));
    HBox infoArea = new HBox();
    infoArea.setPadding(new Insets(10,10,10,10));

    rootNode.setCenter(cardView);
    rootNode.setRight(playArea);
    rootNode.setBottom(infoArea);

    Button dealCardsButton = new Button();
    dealCardsButton.setText("Deal cards");
    Button checkCardsButton = new Button();
    checkCardsButton.setText("Check cards");

    TextField cardSumField = new TextField();
    cardSumField.setText("0");
    TextField flushField = new TextField();
    flushField.setText("No");

    TextField womanField = new TextField();

    Image c12 = new Image("/images/playingCardsSizeSmall/c13.png");
    ImageView imageView1 = new ImageView();
    ImageView imageView2 = new ImageView();
    ImageView imageView3 = new ImageView();
    ImageView imageView4 = new ImageView();
    ImageView imageView5 = new ImageView();
    imageView2.setImage(c12);

    cardView.getChildren().addAll(imageView1, imageView2, imageView3, imageView4, imageView5);

    playArea.getChildren().addAll(dealCardsButton, checkCardsButton);

    infoArea.getChildren().addAll(cardSumField, flushField);

    Scene scene = new Scene(rootNode, 900, 500);

    stage.setScene(scene);
    stage.setTitle("Playing card game");

    dealCardsButton.setOnAction(actionEvent -> {
          System.out.println("dealHand button pressed");

          dealtHand = deckOfCards.dealHand(5);
          //imageView1.setImage(dealtHand.getPlayingCardHand().get(0));
          //imageView2.setImage(cardImages);
        }
        );

    checkCardsButton.setOnAction(actionEvent -> {
          System.out.println("checkHand button pressed");

          flushField.setText(dealtHand.isFlush()?"YES":"NO");
          System.out.println(dealtHand.isFlush()?"YES":"NO");

          womanField.setText(dealtHand.isClubWomanInHand()?"YES":"NO");
          System.out.println(dealtHand.isClubWomanInHand()?"YES":"NO");


          if (!dealtHand.listOfHeartsInHand().isEmpty()) {
              System.out.println("There are cards of heart in the hand");
            }

            System.out.println("The sum of the cards is: " + dealtHand.sumOfhand());
            cardSumField.setText(dealtHand.sumOfhand() + "");
        }
        );

    stage.show();
  }

  public static void appMain(String[] args) {
    launch(args);
  }
}
