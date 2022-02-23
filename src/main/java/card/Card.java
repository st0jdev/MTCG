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

    @Getter
    @Setter
    MonsterName _mName;

    public Card(String name, int damage, ElementType type ,MonsterName mName){

        _name=name;
        _damage=damage;
        _type=type;
        _mName=mName;

    }


}
