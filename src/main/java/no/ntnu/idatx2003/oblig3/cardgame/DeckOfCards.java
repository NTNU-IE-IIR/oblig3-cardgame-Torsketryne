package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DeckOfCards {
  private final HashMap<String, PlayingCard> deckOfCards;

  public DeckOfCards() {
    char[] suits = {'H', 'D', 'C', 'S'};
    String[] playingCardDeckReference = new String[52];
    this.deckOfCards = new HashMap<>();

    int index = 0;
    for (char suit : suits) {
      for (int face = 1; face < 14; face++) {
        PlayingCard playingCard = new PlayingCard(suit, face);
        this.deckOfCards.put(playingCard.getAsString(), playingCard);
        playingCardDeckReference[index] = playingCard.getAsString();
      }
    }
  }

  public PlayingCardHand dealHand(int sizeOfHand) {
    if (sizeOfHand < 0) {
      throw new IllegalArgumentException("Less than zero cards cannot be dealt");
    } else if (sizeOfHand > deckOfCards.size()) {
      throw new IllegalArgumentException("More cards than what is in the deck cannot be dealt");
    }
    PlayingCardHand playingCardHand = new PlayingCardHand();
    Random random = new Random();
    int count = 0;

    while (sizeOfHand > count) {
      int index = random.nextInt(52);
      PlayingCard playingCard = deckOfCards.get(index);
      deckOfCards.remove(index);
      playingCardHand.addPlayingCardToHand(playingCard);
      count++;
    }
    return playingCardHand;
  }

  public PlayingCard getPlayingCardSpecific(char suit, int face) {
    if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
      throw new IllegalArgumentException("Parameter suit must be one of H, D, C or S");
    }
    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Parameter face must be a number between 1 to 13");
    }
    boolean looking = true;
    PlayingCard playingCard = null;
    int index = 0;
    while (looking && index < 53) {
      playingCard = deckOfCards.get(index);
      if (playingCard.getFace() == face && playingCard.getSuit() == suit) {
        looking = false;
      }
      index++;
    }
    if (looking) {
      throw new RuntimeException("Card could not be found");
    }
    return playingCard;
  }

  public PlayingCard getPlayingCardIndex(int index) {
    return deckOfCards.get(index);
  }
}
