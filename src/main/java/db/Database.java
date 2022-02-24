package db;

import http.ContentType;
import http.HttpStatus;
import lombok.Getter;
import server.Response;

import java.sql.*;

@Getter
public class Database {

    private Connection c;


    public Database(){
        try{
            c = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/mtcg",
                    "postgres",
                    "swe1pw"
            );
        }catch (SQLException e){
            System.out.println("Wir kommen hinein...........");
            e.printStackTrace();
        }

    }

    public Response registerUser(String username, String password){

        //Error cannot commit when AutoCommit is enabled
        try {
            this.c.setAutoCommit(false);
        }catch (Exception e){
            e.getMessage();
        }

        try {


            String query = "INSERT INTO public.player (username, password) VALUES (?, ?);";

            PreparedStatement stmt = this.c.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.execute();

            this.disconnect();


        }catch (Exception e) {
            //System.out.println(e.getMessage());

            return new Response(
                    HttpStatus.NOT_ALLOWED,
                    ContentType.JSON,
                    "{message: \"Ein Nutzer verwendet bereits diesen Namen.\" }"
            );

        }

        return new Response(
                HttpStatus.CREATED,
                ContentType.JSON,
                "{message: \"Erfolgreich registriert.\" }"
        );




    }

    public Response loginUser(String username, String password){

        try {
            this.c.setAutoCommit(false);
        }catch (Exception e){
            e.getMessage();
        }


        try {


            String query = "SELECT username, password FROM public.player WHERE username = ?;";

            PreparedStatement stmt = this.c.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet result=stmt.executeQuery();

            result.next();


            if(result.getString("password").equals(password)){

                this.disconnect();

                return new Response(
                        HttpStatus.CREATED,
                        ContentType.JSON,
                        "{message: \"Erfolgreich eingeloggt.\" }"
                );


            }else{

                this.disconnect();

                return new Response(
                        HttpStatus.NOT_ALLOWED,
                        ContentType.JSON,
                        "{message: \"Sie haben das falsche Passwort/Usernamen eingegeben.\" }"
                );

            }




        }catch (Exception e){
            //System.out.println(e.getMessage());

        }


        return null;

    }

    public void stats(String username){

        String username1="";
        int elo = 0;
        int wins = 0;
        int losses=0;
        int games=0;



        String query = "SELECT username, elo, wins, losses, games FROM public.player WHERE username = ?;";

        try {
            PreparedStatement stmt = this.c.prepareStatement(query);

            stmt.setString(1, username);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                username1 =resultSet.getString(1);
                elo = resultSet.getInt(2);
                wins = resultSet.getInt(3);
                losses = resultSet.getInt(4);
                games = resultSet.getInt(5);

            }

            System.out.println(username1+"-"+elo+"-"+wins+"-"+losses+"-"+games);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void scoreboard(){

        String username1="";
        int elo = 0;
        int wins = 0;
        int losses=0;
        int games=0;
        int place=0;



        String query = "SELECT username, elo, wins, losses,games FROM public.player ORDER BY elo DESC;";

        try {
            PreparedStatement stmt = this.c.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                place++;
                username1 =resultSet.getString(1);
                elo = resultSet.getInt(2);
                wins = resultSet.getInt(3);
                losses = resultSet.getInt(4);
                games = resultSet.getInt(5);


                System.out.println(place+"-"+username1+"-"+elo+"-"+wins+"-"+losses+"-"+games);
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Response changePassword(String username, String password,String newPassword,String confNewPassword){

        String query = "SELECT username, password FROM public.player WHERE username = ?;";

        PreparedStatement stmt = null;
        try {
            stmt = this.c.prepareStatement(query);

            stmt.setString(1, username);
            ResultSet result=stmt.executeQuery();

            result.next();
            if(result.getString("password").equals(password)){


                if(newPassword.equals(confNewPassword)) {


                    String query2 = "UPDATE public.player set password = ? where username = ?;";

                    PreparedStatement stmt2 = this.c.prepareStatement(query2);
                    stmt2.setString(1, newPassword);
                    stmt2.setString(2, username);
                    stmt2.execute();

                    return new Response(
                            HttpStatus.CREATED,
                            ContentType.JSON,
                            "{message: \"Erfolgreich geändert.\" }"
                    );
                }
            }else{

                return new Response(
                        HttpStatus.CREATED,
                        ContentType.JSON,
                        "{message: \"Etwas ist schiefgelaufen. Überprüfen Sie die Werte.\" }"
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    return null;

    }

    public void win(String username){

        String query = "UPDATE public.player set wins = wins + 1 where username = ?;";

        try {
            PreparedStatement stmt = this.c.prepareStatement(query);
            stmt.setString(1, username);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loss(String username){

        String query = "UPDATE public.player set losses = losses + 1 where username = ?;";

        try {
            PreparedStatement stmt = this.c.prepareStatement(query);
            stmt.setString(1, username);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            this.c.commit();
            this.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
