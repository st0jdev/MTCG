package card;

import lombok.Getter;
import lombok.Setter;

public class SpellCard extends Card{


    @Getter
    @Setter
    CardType _cType;

    public SpellCard(String name, int damage, ElementType type){

        super(name,damage,type,MonsterName.SPELL);

        _cType=CardType.SPELL;

    }



}
