package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DeckOfCards {
  private final HashMap<String, PlayingCard> deckOfCards;
  private final String[] playingCardDeckReference;

  public DeckOfCards() {
    char[] suits = {'H', 'D', 'C', 'S'};
    this.playingCardDeckReference = new String[52];
    this.deckOfCards = new HashMap<>();

    int index = 0;
    for (char suit : suits) {
      for (int face = 1; face < 14; face++) {
        PlayingCard playingCard = new PlayingCard(suit, face);
        this.deckOfCards.put(playingCard.getAsString(), playingCard);
        this.playingCardDeckReference[index] = playingCard.getAsString();
      }
    }
  }

  private ArrayList<PlayingCard> makeArrayListFromHashmap(HashMap<String, PlayingCard> hashMap) {
    ArrayList<PlayingCard> arrayList= null;

    if (hashMap != null) {
      arrayList = new ArrayList<>(hashMap.values());
    }
    return arrayList;
  }

  public PlayingCardHand dealHand(int sizeOfHand) {
    if (sizeOfHand < 0) {
      throw new IllegalArgumentException("Less than zero cards cannot be dealt");
    } else if (sizeOfHand > this.deckOfCards.size()) {
      throw new IllegalArgumentException("More cards than what is in the deck cannot be dealt");
    }

    ArrayList<PlayingCard> deckOfCardsList = makeArrayListFromHashmap(this.deckOfCards);
    PlayingCardHand playingCardHand = new PlayingCardHand();
    Random random = new Random();
    int count = 0;

    while (sizeOfHand > count) {
      int randomNumber = random.nextInt(52);
      PlayingCard playingCard = deckOfCardsList.get(randomNumber);
      this.deckOfCards.remove(deckOfCardsList.get(randomNumber).getAsString());
      playingCardHand.addPlayingCardToHand(playingCard);
      count++;
    }
    return playingCardHand;
  }

  public void refillDeck() {
    for (String k : this.playingCardDeckReference) {
      if (!this.deckOfCards.containsKey(k)) {
        char[] signAndFace = k.toCharArray();
        this.deckOfCards.put(k, new PlayingCard(signAndFace[0], signAndFace[1]));
      }
    }
  }
}
