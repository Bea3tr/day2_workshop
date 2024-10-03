package card;

import java.security.SecureRandom;
import java.util.*;
import java.io.Console;

public class CardDeck {

    public static final String[] SUIT = {"Diamond", "Spade", "Clubs", "Hearts"};
    public static final String[] NAME = {
        "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
        "Eight", "Nine", "Ten", "Jack", "Queen", "King"
    };
    public static final int[] VALUE = {
        1, 2, 3, 4, 5, 6, 7, 
        8, 9, 10, 10, 10, 10
    };
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

    public Card[] shuffle(Card[] cards) {

        /* Using Collections.shuffle 
         * List<Card> cardsList = Arrays.asList(cards);
         * Collections.shuffle(cardsList);
         * Card[] shuffledDeck = cardsList.toArray(new Card[52]);
        */
        
        Random rand = new SecureRandom();
        Card[] shuffledDeck = new Card[52];
        ArrayList<Integer> randList = new ArrayList<Integer>();
        
        for (int i = 0; i < cards.length; i++) {
            int idx = rand.nextInt(cards.length);
            while (randList.contains(idx)){
                idx = rand.nextInt(cards.length);
            }
            randList.add(idx);
            shuffledDeck[i] = cards[idx];
        }
        return shuffledDeck;
    }

    public void draw(Card[] cards) {

        Console cons = System.console();
        boolean isStop = false;
        ArrayList<Integer> randList = new ArrayList<Integer>();

        while (!isStop){
            System.out.println("Please draw a card");
            Random rand = new SecureRandom();
            int drawn = rand.nextInt(cards.length);
            while (randList.contains(drawn)) {
                drawn = rand.nextInt(cards.length);
            }

            System.out.printf("The card you have drawn is: %d\n", cards[drawn]);

            String input = cons.readLine("Do you wish to draw another card? ");

            if (input.equals("no") || randList.size() == cards.length){
                isStop = true;
            }
         }
    }
}
