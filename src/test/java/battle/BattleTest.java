package battle;

import card.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTest {

    Card c1;
    Card c2;
    Battle battle=new Battle(null,null);
    int result;

    @Test
    void GoblinVsDragon(){

        c1=new MonsterCard("FireGoblin",90, ElementType.FIRE, MonsterName.GOBLIN);
        c2=new MonsterCard("FireDragon",90, ElementType.FIRE, MonsterName.DRAGON);

        result=battle.MonsterFight(c1,c2);

        assertEquals(result,2);

    }

    @Test
    void WizardVsOrks(){

        c1=new MonsterCard("FireWizard",90, ElementType.FIRE, MonsterName.WIZZARD);
        c2=new MonsterCard("FireOrk",90, ElementType.FIRE, MonsterName.ORK);

        result=battle.MonsterFight(c1,c2);

        assertEquals(result,1);

    }

    @Test
    void KnightVsWaterSpell(){

        c1=new MonsterCard("FireKnight",90, ElementType.FIRE, MonsterName.KNIGHT);
        c2=new SpellCard("WaterSpell",90, ElementType.WATER);

        result=battle.SpellFight(c1,c2);

        assertEquals(result,2);

    }

    @Test
    void KrakenVsSpell(){

        c1=new MonsterCard("FireKraken",90, ElementType.FIRE, MonsterName.KRAKEN);
        c2=new SpellCard("WaterSpell",90, ElementType.WATER);

        result=battle.SpellFight(c1,c2);

        assertEquals(result,1);

    }

    @Test
    void FireElveVsDragon(){

        c1=new MonsterCard("FireElve",90, ElementType.FIRE, MonsterName.ELVE);
        c2=new MonsterCard("FireDragon",120, ElementType.WATER,MonsterName.DRAGON);

        result=battle.MonsterFight(c1,c2);

        assertEquals(result,1);

    }

    @Test
    void sameDamageSameMonster(){

        c1=new MonsterCard("WaterGoblin",120, ElementType.WATER, MonsterName.GOBLIN);
        c2=new MonsterCard("WaterGoblin",120, ElementType.WATER,MonsterName.GOBLIN);

        result=battle.MonsterFight(c1,c2);

        assertEquals(result,0);

    }

    @Test
    void WaterVsFire(){

        c1=new SpellCard("WaterSpell",120, ElementType.WATER);
        c2=new SpellCard("FireSpell",120, ElementType.FIRE);

        result=battle.SpellFight(c1,c2);

        assertEquals(result,1);

    }

    @Test
    void NormalVsFire(){

        c1=new SpellCard("NormalSpell",120, ElementType.NORMAL);
        c2=new SpellCard("FireSpell",120, ElementType.FIRE);

        result=battle.SpellFight(c1,c2);

        assertEquals(result,2);

    }

    @Test
    void NormalVsWater(){

        c1=new SpellCard("NormalSpell",120, ElementType.NORMAL);
        c2=new SpellCard("WaterSpell",120, ElementType.WATER);

        result=battle.SpellFight(c1,c2);

        assertEquals(result,1);

    }

    @Test
    void NormalVsNormal(){

        c1=new SpellCard("NormalSpell",120, ElementType.NORMAL);
        c2=new SpellCard("NormalGoblin",120, ElementType.NORMAL);

        result=battle.SpellFight(c1,c2);

        assertEquals(result,0);

    }

}
