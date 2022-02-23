package Battle;

import card.*;
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

            System.out.println("Runde "+rounds+":");

            //Deck von Spieler 1 leer
            if(_player1.get_Deck().get_Deck().size()==0) {

                System.out.println(_player2.get_username()+" hat das Spiel gewonnen.");
                _player2.win();
                _player1.loss();
                break;
            }
            //Deck von Spieler 2 leer
            if(_player2.get_Deck().get_Deck().size()==0) {

                System.out.println(_player1.get_username()+" hat das Spiel gewonnen.");
                _player1.win();
                _player2.loss();
                break;

            }

            System.out.println( _player1.get_Deck().fCard().get_name()+" von "+_player1.get_username()+" zieht in den Kampf.");
            System.out.println( _player2.get_Deck().fCard().get_name()+" von "+_player2.get_username()+" zieht in den Kampf.");

            //Vergleichen von Karten
            //Monsterkampf
            if(_player1.get_Deck().fCard() instanceof MonsterCard && _player2.get_Deck().fCard() instanceof MonsterCard){


               roundR = MonsterFight(_player1.get_Deck().fCard(),_player2.get_Deck().fCard());


            }else{



                roundR = SpellFight(_player1.get_Deck().fCard(),_player2.get_Deck().fCard());
            }

            switch(roundR){

                case 0: System.out.println("Die Runde verlief unentschieden.");

                case 1: System.out.println(_player1.get_username()+" gewinnt die Runde. "+_player1.get_Deck().fCard().get_name()+" besiegte "+_player2.get_Deck().fCard().get_name());

                case 2: System.out.println(_player2.get_username()+" gewinnt die Runde. "+_player2.get_Deck().fCard().get_name()+" besiegte "+_player1.get_Deck().fCard().get_name());



            }

            takeCard(roundR,_player1.get_Deck().fCard(),_player2.get_Deck().fCard());


        }

        if(_player1.get_Deck().get_Deck().size()!=0 && _player2.get_Deck().get_Deck().size()!=0){

            System.out.println("Keiner der beiden Spieler hat gewonnen! Unentschieden!");
            _player1.draw();
            _player2.draw();

        }



    }

    private void takeCard(int result, Card c1, Card c2){

        _player1.get_Deck().get_Deck().removeFirst();
        _player2.get_Deck().get_Deck().removeFirst();

        switch(result){

            case 0:{

                System.out.println("Keine Karten wurden übernommen.");
                _player1.get_Deck().get_Deck().add(c1);
                _player2.get_Deck().get_Deck().add(c2);
                break;
            }


            case 1:{

                System.out.println(_player1.get_username()+" übernahm "+c2.get_name());
                _player1.get_Deck().get_Deck().add(c1);
                _player1.get_Deck().get_Deck().add(c2);
                break;

            }


            case 2:{

                System.out.println(_player2.get_username()+" übernahm "+c1.get_name());
                _player2.get_Deck().get_Deck().add(c2);
                _player2.get_Deck().get_Deck().add(c1);
                break;

            }


        }


    }


    private int MonsterFight(Card c1, Card c2){

        int damage1= c1.get_damage();
        int damage2= c2.get_damage();

        if(c1.get_mName().equals(MonsterName.GOBLIN) && c2.get_mName().equals(MonsterName.DRAGON)){

            return 2;

        }else if (c1.get_mName().equals(MonsterName.DRAGON) && c2.get_mName().equals(MonsterName.GOBLIN)){


            return 1;

        }else if(c1.get_mName().equals(MonsterName.WIZZARD) && c2.get_mName().equals(MonsterName.ORK)){

            return 1;

        }else if(c1.get_mName().equals(MonsterName.ORK) && c2.get_mName().equals(MonsterName.WIZZARD)){

            return 2;

        }else if(c1.get_mName().equals(MonsterName.ELVE) && c1.get_type().equals(ElementType.FIRE) && c2.get_mName().equals(MonsterName.DRAGON)){

            return 1;

        }else if(c1.get_mName().equals(MonsterName.DRAGON) && c2.get_type().equals(ElementType.FIRE) && c2.get_mName().equals(MonsterName.ELVE)){

            return 2;

        }else if(damage1==damage2){

           return 0;

       }else if (damage1>damage2){

           return 1;

       }else {

           return 2;
       }


    }

    private int SpellFight(Card c1, Card c2){

        if(c1.get_mName().equals(MonsterName.KNIGHT) && c2.get_type().equals(ElementType.WATER)){

            return 2;

        }

        if(c2.get_mName().equals(MonsterName.KNIGHT) && c1.get_type().equals(ElementType.WATER)){

            return 1;

        }

        if(c1.get_mName().equals(MonsterName.KRAKEN)){

            return 1;

        }

        if(c2.get_mName().equals(MonsterName.KRAKEN)){

            return 1;

        }

            if(c1.get_type().equals(ElementType.WATER) && c2.get_type().equals(ElementType.FIRE)){

                if(c1.get_damage() * 2 > c2.get_damage() / 2){

                    return 1;

                }else if (c1.get_damage() * 2 < c2.get_damage() / 2){

                    return 2;
                }else {

                    return 0;
                }


            }

            if(c1.get_type().equals(ElementType.FIRE) && c2.get_type().equals(ElementType.WATER)){

                if(c1.get_damage() / 2 > c2.get_damage() * 2){

                    return 1;

                }else if (c1.get_damage() / 2 < c2.get_damage() * 2){

                    return 2;

                }else {

                    return 0;
                }


            }

            if(c1.get_type().equals(ElementType.FIRE) && c2.get_type().equals(ElementType.NORMAL)){

                if(c1.get_damage() * 2 > c2.get_damage() / 2){

                    return 1;

                }else if (c1.get_damage() * 2 < c2.get_damage() / 2){

                    return 2;
                }else {

                    return 0;
                }


            }

            if(c1.get_type().equals(ElementType.NORMAL) && c2.get_type().equals(ElementType.FIRE)){

                if(c1.get_damage() / 2 > c2.get_damage() * 2){

                    return 1;

                }else if (c1.get_damage() / 2 < c2.get_damage() * 2){

                    return 2;

                }else {

                    return 0;
                }


            }

            if(c1.get_type().equals(ElementType.NORMAL) && c2.get_type().equals(ElementType.WATER)){

                if(c1.get_damage() * 2 > c2.get_damage() / 2){

                    return 1;

                }else if (c1.get_damage() * 2 < c2.get_damage() / 2){

                    return 2;
                }else {

                    return 0;
                }


            }

            if(c1.get_type().equals(ElementType.WATER) && c2.get_type().equals(ElementType.NORMAL)){

                if(c1.get_damage() / 2 > c2.get_damage() * 2){

                    return 1;

                }else if (c1.get_damage() / 2 < c2.get_damage() * 2){

                    return 2;

                }else {

                    return 0;
                }


            }



        return 0;


    }


}
