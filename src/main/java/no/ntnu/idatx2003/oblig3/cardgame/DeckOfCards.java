package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private final ArrayList<PlayingCard> deckOfCards;

  public DeckOfCards() {
    char[] suits = {'H', 'D', 'C', 'S'};
    this.deckOfCards = new ArrayList<>();

    int index = 0;
    for (char suit : suits) {
      for (int face = 1; face < 14; face++) {
        PlayingCard playingCard = new PlayingCard(suit, face);
        this.deckOfCards.add(playingCard);
      }
    }
  }

  public PlayingCardHand dealHand(int sizeOfHand) {
    if (sizeOfHand < 0) {
      throw new IllegalArgumentException("Less than zero cards cannot be dealt");
    } else if (sizeOfHand > this.deckOfCards.size()) {
      throw new IllegalArgumentException("More cards than what is in the deck cannot be dealt");
    }

    PlayingCardHand playingCardHand = new PlayingCardHand();
    Random random = new Random();
    int count = 0;

    while (sizeOfHand > count) {
      int randomNumber = random.nextInt(deckOfCards.size());
      PlayingCard playingCard = deckOfCards.get(randomNumber);
      this.deckOfCards.remove(deckOfCards.get(randomNumber));
      playingCardHand.addPlayingCardToHand(playingCard);
      count++;
    }
    return playingCardHand;
  }

  public ArrayList<PlayingCard> getDeckOfCards() {
    return this.deckOfCards;
  }
}
