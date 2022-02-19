package user;

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

    public User(String username, String password, int coins){

        _username=username;
        _password=password;
        _coins=coins;

    }



}
