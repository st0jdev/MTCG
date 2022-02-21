package Battle;

import card.Card;
import card.Deck;
import card.MonsterCard;
import user.User;

public class Battle {

    final int rounds = 100;
    User _player1;
    User _player2;


    public Battle(User u1,User u2){

        this._player1=u1;
        this._player2=u2;

    }

    public void fight(){

        int roundR;

        for(int i=0;i<rounds;i++){

            //Deck von Spieler 1 leer
            if(_player1.get_Deck().get_Deck().size()==0) {

                System.out.println("Spieler 2 gewann.");
                break;
            }
            //Deck von Spieler 2 leer
            if(_player2.get_Deck().get_Deck().size()==0) {

                System.out.println("Spieler 1 gewann.");
                break;

            }

            //Vergleichen von Karten
            //Monsterkampf
            if(_player1.get_Deck().fCard() instanceof MonsterCard && _player2.get_Deck().fCard() instanceof MonsterCard){


               roundR = MonsterFight(_player1.get_Deck().fCard(),_player2.get_Deck().fCard());


            }else{



                roundR = SpellFight(_player1.get_Deck().fCard(),_player2.get_Deck().fCard());
            }


        }



    }


    private int MonsterFight(Card c1, Card c2){

        int damage1= c1.get_damage();
        int damage2= c2.get_damage();

        //Kein Gewinner
       if(damage1==damage2){

           return 0;

       }else if (damage1>damage2){

           return 1;

       }else {

           return 2;
       }


    }

    private int SpellFight(Card c1, Card c2){


        return 0;


    }


}
