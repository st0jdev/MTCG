package user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    User player;

    @Test
    void newUser(){

        player=new User("Stefan","Password");

        assertEquals(player.get_coins(),20);

    }

    @Test
    void playGame(){

        player=new User("Stefan","Password");

        player.win();

        assertEquals(player.get_games(),1);
    }

    @Test
    void firstWin(){

        player=new User("Stefan","Password");

        player.win();

        assertEquals(player.get_wins(),1);

    }

    @Test
    void eloAfter10Wins(){

        player=new User("Stefan","Password");

        for(int i=0;i<10;i++){

            player.win();

        }

        assertEquals(player.get_elo(),130);


    }

    @Test
    void eloAfter10Losses(){

        player=new User("Stefan","Password");

        for(int i=0;i<10;i++){

            player.loss();

        }

        assertEquals(player.get_elo(),50);

    }

    @Test
    void bought2Packages(){

        player=new User("Stefan","Password");

       player.buyPackage();
       player.buyPackage();

        assertEquals(player.get_coins(),10);

    }

    @Test
    void lostGame(){

        player=new User("Stefan","Password");

        player.loss();

        assertEquals(player.get_losses(),1);

    }

    @Test
    void wonGame(){

        player=new User("Stefan","Password");

        player.win();

        assertEquals(player.get_wins(),1);

    }


}
