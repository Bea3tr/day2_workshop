package card;

import java.security.SecureRandom;
import java.util.*;
import java.io.Console;

public class CardDeck {

    private static final int NUM_CARD = 52;

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
