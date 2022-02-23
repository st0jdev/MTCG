package user;

import card.Deck;
import card.Stack;
import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    String _username;

    @Getter
    @Setter
    String _password;

    @Getter
    @Setter
    int _coins;

    @Getter
    @Setter
    Deck _Deck;

    @Getter
    @Setter
    Stack _Stack;

    @Getter
    @Setter
    int _elo;

    @Getter
    @Setter
    int _wins;

    @Getter
    @Setter
    int _losses;

    @Getter
    @Setter
    int _games;

    public User(String username, String password){

        _username=username;
        _password=password;
        _coins=20;
        _Deck=new Deck();
        _Stack=new Stack();
        _elo=100;
        _wins=0;
        _losses=0;
        _games=0;


    }

    public void win(){

        this._elo+=3;
        this._games++;

    }

    public void loss(){

        this._elo-=5;
        this._games++;

    }

    public void draw(){

        this._games++;

    }



}
