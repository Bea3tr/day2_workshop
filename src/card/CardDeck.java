package card;

import java.security.SecureRandom;
import java.util.*;
import java.io.Console;

public class CardDeck {

    public static final String[] SUIT = {"Diamond", "Spade", "Clubs", "Hearts"};
    public static final String[] NAME = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
                                        "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    public static final int[] VALUE = {1, 2, 3, 4, 5, 6, 7, 
                                        8, 9, 10, 10, 10, 10};
    private static final int NUM_CARD = 52;
    protected Card[] cards;

    public CardDeck() {
        cards = new Card[52];
        int idx = 0;
        for (int s = 0; s < SUIT.length; s++) {
            String suit = SUIT[s];

            for (int n = 0; n < NAME.length; n++) {
                String name = NAME[n];
                int value = VALUE[n];

                Card card = new Card(suit, name, value);
                cards[idx] = card;
                idx++;
            }
        }
    }

    public Card get() {
        return this.get(0);
    }
    public Card get(int pos) {
        return this.cards[pos];
    }

    public ArrayList<Integer> shuffle() {
        
        Random rand = new SecureRandom();
        ArrayList<Integer> deck =new ArrayList<Integer>();
        for (int i=0; i < NUM_CARD; i++) {
            deck.add(i);
        }

        ArrayList<Integer> shuffledDeck = new ArrayList<Integer>();
        while (deck.size() > 0) {
            int idx = rand.nextInt(deck.size());
            shuffledDeck.add(deck.get(idx));
            deck.remove(idx);
        }
        return shuffledDeck;
    }

    public void draw(ArrayList<Integer> deck) {

        Console cons = System.console();
        boolean isStop = false;

        while (!isStop){
            System.out.println("Please draw a card");
            Random rand = new SecureRandom();
            int drawn = rand.nextInt(deck.size());

            System.out.printf("The card you have drawn is: %d\n", deck.get(drawn));
            deck.remove(drawn);

            String input = cons.readLine("Do you wish to draw another card? ");
            if (input.equals("no") || deck.size() == 0){
                isStop = true;
            }
         }
    }
}
