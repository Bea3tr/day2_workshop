package card;

public class Main {
    public static void main(String[] args) {
        
        CardDeck deck = new CardDeck();
        Card card = deck.get(5);

        System.out.printf("Suit: %s, Name: %s, Vale: %d\n", card.getSuit(), card.getName(), card.getValue());

        /* ArrayList<Integer> sDeck = deck.shuffle();

        for (int card : sDeck) {
            System.out.println(card);
        }

        deck.draw(sDeck);
        */
    }
}
