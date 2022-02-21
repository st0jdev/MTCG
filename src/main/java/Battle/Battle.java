package Battle;

import card.Deck;
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


        }



    }


}
