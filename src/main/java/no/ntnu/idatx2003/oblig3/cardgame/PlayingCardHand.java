package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class PlayingCardHand {

  private final ArrayList<PlayingCard> handOfPlayingCards;

  public PlayingCardHand() {
    handOfPlayingCards = new ArrayList<>();
  }

  public void addPlayingCardToHand(PlayingCard playingCard) {
    if (playingCard == null) {
      throw new IllegalArgumentException("Parameter cannot be of value null");
    }
    handOfPlayingCards.add(playingCard);
  }

  public boolean removePlayingCardFromHand(PlayingCard playingCard) {
    if (playingCard == null) {
      throw new IllegalArgumentException("Parameter cannot be of value null");
    }
    return handOfPlayingCards.remove(playingCard);
  }

  public void emptyPlayingCardHand() {
    handOfPlayingCards.clear();
  }

  public ArrayList<PlayingCard> getPlayingCardHand() {
    return handOfPlayingCards;
  }
}
