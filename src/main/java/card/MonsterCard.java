package card;

import lombok.Getter;
import lombok.Setter;

public class MonsterCard extends Card{


    @Getter
    @Setter
    CardType _cType;

    public MonsterCard(String name, int damage, ElementType type){

        super(name,damage,type);

        _cType=CardType.MONSTER;

    }


}
