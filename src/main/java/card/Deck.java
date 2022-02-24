package card;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Getter
public class Deck {

    private int _nCards;

    private LinkedList<Card> _Deck;

    Random rnd = new Random();

    public Deck(){

        _nCards=4;
        _Deck = new LinkedList<>();

    }

    public void delDeck(){

        this._Deck.clear();
    }

    public Card rndCard(){
        int randomPosition = rnd.nextInt(this._Deck.size());
        Card c1 = this._Deck.get(randomPosition);
        return c1;
    }





}
