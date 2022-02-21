import Battle.Battle;
import user.User;

public class main {

    public static void main(String[] args){

        System.out.println("Willkommen bei MTCG!");

        User u1=new User("stefan","Test",20);
        User u2=new User("stefan","Test",20);

        Battle battle=new Battle(u1,u2);

        battle.fight();

    }
}
