package card;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        CardDeck deck = new CardDeck();

        ArrayList<Integer> sDeck = deck.shuffle();

        for (int card : sDeck) {
            System.out.println(card);
        }

        deck.draw(sDeck);
    }
}
