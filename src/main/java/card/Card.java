package card;

import lombok.Getter;
import lombok.Setter;

public class Card {

    @Getter
    @Setter
    String _name;

    @Getter
    @Setter
    int _damage;

    @Getter
    @Setter
    ElementType _type;

    public Card(String name, int damage, ElementType type){

        _name=name;
        _damage=damage;
        _type=type;

    }


}
