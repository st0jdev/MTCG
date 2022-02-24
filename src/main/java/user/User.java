package user;

import card.Deck;
import card.Stack;
import lombok.Getter;
import lombok.Setter;

@Getter

public class User {

    private String _username;

    private String _password;

    private int _coins;

    private Deck _Deck;

    private Stack _Stack;

    private int _elo;

    private int _wins;

    private int _losses;

    private int _games;

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
        this._wins++;
        this._games++;

    }

    public void loss(){

        this._elo-=5;
        this._losses++;
        this._games++;

    }

    public void draw(){

        this._games++;

    }

    public void buyPackage(){

        this._coins-=5;

    }




}
