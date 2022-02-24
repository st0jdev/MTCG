package server.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {


    @JsonAlias({"Username"})
    private String username;

    @JsonAlias({"Password"})
    private String password;

    @JsonAlias({"NewPassword"})
    private String newpassword;

    @JsonAlias({"ConfNewPassword"})
    private String confnewpassword;

    public UserModel(){}

    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }

}
