package card;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Card {

    protected String _name;

    protected int _damage;

    protected ElementType _type;

    protected MonsterName _mName;

    public Card(String name, int damage, ElementType type ,MonsterName mName){

        _name=name;
        _damage=damage;
        _type=type;
        _mName=mName;

    }


}
