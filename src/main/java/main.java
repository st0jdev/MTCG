import Battle.Battle;
import user.User;

public class main {

    public static void main(String[] args){

        System.out.println("Willkommen bei MTCG!");

        User u1=new User("stefan","Test");
        User u2=new User("stefan2","Test");

        Battle battle=new Battle(u1,u2);

        battle.fight();

    }
}
