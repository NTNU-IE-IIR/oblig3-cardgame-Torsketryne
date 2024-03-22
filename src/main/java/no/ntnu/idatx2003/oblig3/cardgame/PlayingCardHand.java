package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayingCardHand {

  private final ArrayList<PlayingCard> handOfPlayingCards;

  public PlayingCardHand() {
    this.handOfPlayingCards = new ArrayList<>();
  }

  public void addPlayingCardToHand(PlayingCard playingCard) {
    if (playingCard == null) {
      throw new IllegalArgumentException("Parameter cannot be of value null");
    }
    this.handOfPlayingCards.add(playingCard);
  }

  public boolean removePlayingCardFromHand(PlayingCard playingCard) {
    if (playingCard == null) {
      throw new IllegalArgumentException("Parameter cannot be of value null");
    }
    return this.handOfPlayingCards.remove(playingCard);
  }

  public void emptyPlayingCardHand() {
    this.handOfPlayingCards.clear();
  }

  public ArrayList<PlayingCard> getPlayingCardHand() {
    return this.handOfPlayingCards;
  }

  public Iterator<PlayingCard> getPlayingCardHandIterator() {return this.handOfPlayingCards.iterator();}

  public boolean isFlush() {
    boolean answer = false;

    int cCount = 0;
    int sCount = 0;
    int hCount = 0;
    int dCount = 0;

    for (PlayingCard playingCard : this.handOfPlayingCards) {
      if (playingCard.getSuit() == 'C') {
        cCount += 1;
      } else if (playingCard.getSuit() == 'S') {
        sCount += 1;
      }
       else if (playingCard.getSuit() == 'H') {
        hCount += 1;
      }
       else if (playingCard.getSuit() == 'D') {
        dCount += 1;
      }
    }

    if (cCount == 5 || sCount == 5 || hCount == 5 || dCount == 5) {
      answer = true;
    }

    return answer;
  }

  public int sumOfhand() {
    int sum = 0;
    for (PlayingCard playingCard : this.handOfPlayingCards) {
      sum += playingCard.getFace();
    }
    return sum;
  }

  public ArrayList<PlayingCard> listOfHeartsInHand() {
    ArrayList<PlayingCard> listOfHearts= new ArrayList<>();
    for (PlayingCard playingCard : this.handOfPlayingCards) {
      if (playingCard.getSuit() == 'H') {
        listOfHearts.add(playingCard);
      }
    }
    return listOfHearts;
  }

  public String stringOfHeartsInHand() {
    StringBuilder heartsInHand = new StringBuilder();

    if (!listOfHeartsInHand().isEmpty()) {
      Iterator<PlayingCard> handOfPlayingCardsIterator = getPlayingCardHandIterator();
      while (handOfPlayingCardsIterator.hasNext()) {
        heartsInHand.append(handOfPlayingCardsIterator.next().getAsString());
        if (handOfPlayingCardsIterator.hasNext()) {
          heartsInHand.append(", ");
        }
      }
    }
    return heartsInHand.toString();
  }

  public boolean isClubWomanInHand() {
    boolean answer = false;
    for (PlayingCard playingCard : this.handOfPlayingCards) {
      if (playingCard.getAsString().equals("C12")) {
        answer = true;
      }
    }
    return answer;
  }
}
