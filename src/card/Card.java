package card;

public class Card {

    private final String name;
    private final String suit;
    private final int value;

    // You cannot create a blank card
    public Card(String suit, String name, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    public String getName() {return name;}
    public String getSuit() {return suit;}
    public int getValue() {return value;}

    @Override
    public String toString() {
        return "Card{Suit: %s, Name: %s, Value: %d}".formatted(suit, name, value);
    }   
}
