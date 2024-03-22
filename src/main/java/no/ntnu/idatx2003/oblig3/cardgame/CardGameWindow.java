package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.Event;

public class CardGameWindow
        extends Application {

    private final ImageView cardImage1 = new ImageView();
    private final ImageView cardImage2 = new ImageView();
    private final ImageView cardImage3 = new ImageView();
    private final ImageView cardImage4 = new ImageView();
    private final ImageView cardImage5 = new ImageView();
    private final Image cardBackside = new Image("/images/playingCardsSizeSmall/B0.png");

    private PlayingCardHand dealtHand;


    public ArrayList<Image> prepareImagesFromListOfCards(ArrayList<PlayingCard> listOfCards) {
        ArrayList<Image> listOfCardImages = new ArrayList<>();
        Image image;
        for (PlayingCard playingCard : listOfCards) {
            image = new Image("/images/playingCardsSizeSmall/" + playingCard.getAsString() + ".png");
            listOfCardImages.add(image);
        }
        return listOfCardImages;
    }

    @Override
    public void start(Stage stage) throws Exception {
        DeckOfCards deckOfCards = new DeckOfCards();

        BorderPane rootNode = new BorderPane();

        FlowPane cardView = new FlowPane();
        VBox playArea = new VBox();
        playArea.setPadding(new Insets(10, 10, 10, 10));
        HBox infoArea = new HBox();
        infoArea.setPadding(new Insets(10, 10, 10, 10));

        rootNode.setCenter(cardView);
        rootNode.setRight(playArea);
        rootNode.setBottom(infoArea);

        Button dealCardsButton = new Button();
        dealCardsButton.setText("Deal cards");
        Button checkCardsButton = new Button();
        checkCardsButton.setText("Check cards");

        Text cardSumField = new Text();
        Text flushField = new Text();
        Text womanField = new Text();
        Text heartField = new Text();

        cardView.getChildren().addAll(
                this.cardImage1, this.cardImage2, this.cardImage3, this.cardImage4, this.cardImage5);
        playArea.getChildren().addAll(dealCardsButton, checkCardsButton);
        infoArea.getChildren().addAll(cardSumField, flushField, womanField, heartField);

        dealCardsButton.setOnAction(actionEvent -> {
                    System.out.println("dealHand button pressed");

                    this.dealtHand = deckOfCards.dealHand(5);

                    this.cardImage1.setImage(cardBackside);
                    this.cardImage2.setImage(cardBackside);
                    this.cardImage3.setImage(cardBackside);
                    this.cardImage4.setImage(cardBackside);
                    this.cardImage5.setImage(cardBackside);

                    //imageView1.setImage(dealtHand.getPlayingCardHand().get(0));
                    //imageView2.setImage(cardImages);
                }
        );

        checkCardsButton.setOnAction(actionEvent -> {
                    System.out.println("checkHand button pressed");

                    if (!this.dealtHand.getPlayingCardHand().isEmpty()) {

                        ArrayList<Image> imagesOfCards = prepareImagesFromListOfCards(dealtHand.getPlayingCardHand());

                        this.cardImage1.setImage(imagesOfCards.get(0));
                        this.cardImage2.setImage(imagesOfCards.get(1));
                        this.cardImage3.setImage(imagesOfCards.get(2));
                        this.cardImage4.setImage(imagesOfCards.get(3));
                        this.cardImage5.setImage(imagesOfCards.get(4));

                        flushField.setText(this.dealtHand.isFlush() ? "YES" : "NO");
                        System.out.println(this.dealtHand.isFlush() ? "YES" : "NO");

                        womanField.setText(this.dealtHand.isClubWomanInHand() ? "YES" : "NO");
                        System.out.println(this.dealtHand.isClubWomanInHand() ? "YES" : "NO");


                        if (!this.dealtHand.listOfHeartsInHand().isEmpty()) {
                            System.out.println(this.dealtHand.stringOfHeartsInHand());
                            heartField.setText(this.dealtHand.stringOfHeartsInHand());
                        } else {
                            System.out.println("There are no hearts in the deck");
                            heartField.setText("No hearts in hand");
                        }

                        System.out.println("The sum of the cards is: " + this.dealtHand.sumOfhand());
                        cardSumField.setText(this.dealtHand.sumOfhand() + "");
                    }
                }
        );

        Scene scene = new Scene(rootNode, 900, 500);

        stage.setScene(scene);
        stage.setTitle("Playing card game");
        stage.show();
    }

    public static void appMain(String[] args) {
        launch(args);
    }
}
