import service.App;
import server.Server;

import java.io.IOException;

public class main {

    public static void main(String[] args){

        App app = new App();
        Server server = new Server(10001, app);
        try {
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
