package user;

import card.Deck;
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

    public User(String username, String password){

        _username=username;
        _password=password;
        _coins=20;
        _Deck=new Deck();

    }



}
