package card;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Random;

public class Package {

    List<Card> _cList;
    final int _price=5;



    public Package(){

        Random randType=new Random();
        ElementType randElement;
        int type;

        for(int i=0; i< 5;i++){

            type = randType.nextInt(2);
            randElement= ElementType.generateElement();

            switch(type){


                //Spell
                case 0:{

                    SpellCard sc = new SpellCard(randElement+" Spell",ElementType.generateDamage(),randElement);

                    this._cList.add(sc);
                }

                //Monster
                case 1:{

                    MonsterCard mc= new MonsterCard(randElement+""+MonsterName.generateMonster(),ElementType.generateDamage(),randElement,MonsterName.generateMonster());


                    this._cList.add(mc);


                }


            }



        }


    }


}
