package card;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    @Getter
    @Setter
    List<Card> _Stack;

    public Stack() {

        this._Stack= new ArrayList<>();

    }

    public void addCard(Card c){

        this._Stack.add(c);

    }

    public void removeCard(String _name){

        for(int i=0;i<this._Stack.size();i++){

            if(this._Stack.get(i).get_name().equals(_name)){

                this._Stack.remove(i);
            }

        }

    }

}
