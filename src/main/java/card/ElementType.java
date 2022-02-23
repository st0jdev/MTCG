package card;

import java.util.Random;

public enum ElementType {

    FIRE,WATER,NORMAL;


    static Random rand=new Random();


    public static ElementType generateElement() {


       int randType=rand.nextInt(3);

       switch(randType){

           case 0: return ElementType.FIRE;


           case 1: return ElementType.WATER;


           case 2: return ElementType.NORMAL;

       }

    return ElementType.NORMAL;

   }

   public static int generateDamage(){

        return rand.nextInt(90)+1;

    }
}
