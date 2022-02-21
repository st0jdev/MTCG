package card;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    @Getter
    int _nCards;
    @Getter
    @Setter
    List <Card> _Deck;

    public Deck(){

        _nCards=4;
        _Deck = new ArrayList<>();

    }

    public Card fCard(){

        return this._Deck.get(0);

    }




}
