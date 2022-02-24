package database;

import db.Database;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DatabaseTest {



@Test
void connect() {

    Database db = new Database();

    assertNotEquals(db, null);

}

    @Test
    void createUser() {

        Database db = new Database();

        try {
            db.getC().setAutoCommit(false);
        }catch (Exception e){
            e.getMessage();
        }


        String query = ("INSERT INTO public.player (username, password) VALUES (?, ?);");

        PreparedStatement stmt = null;
        try {
            stmt = db.getC().prepareStatement(query);

            stmt.setString(1, "Max");
            stmt.setString(2, "1234");
            stmt.execute();

            String query2 = ("SELECT password FROM public.player WHERE username = ?;");

            PreparedStatement stmt2 = db.getC().prepareStatement(query2);
            stmt2.setString(1, "Max");
            ResultSet result=stmt2.executeQuery();

            result.next();

            assertEquals(result.getString("password"), "1234");

            String query3 = ("DELETE FROM public.player WHERE username = ?;");

            PreparedStatement stmt3 = db.getC().prepareStatement(query3);
            stmt3.setString(1, "Max");
            stmt3.execute();


            db.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




}
