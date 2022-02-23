package card;

import java.util.Random;

public enum MonsterName {

    GOBLIN,DRAGON,WIZZARD,ORK,KNIGHT,KRAKEN,ELVE,NORMAL,SPELL;

    static Random rand= new Random();

    public static MonsterName generateMonster(){

        int randM= rand.nextInt(7);

        switch(randM){

            case 0: return MonsterName.GOBLIN;

            case 1: return MonsterName.DRAGON;

            case 2: return MonsterName.WIZZARD;

            case 3: return MonsterName.ORK;

            case 4: return MonsterName.KNIGHT;

            case 5: return MonsterName.KRAKEN;

            case 6: return MonsterName.ELVE;


        }

        return MonsterName.NORMAL;
    }

}
