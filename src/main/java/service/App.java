package service;


import com.fasterxml.jackson.core.JsonProcessingException;
import db.Database;
import http.ContentType;
import http.HttpStatus;
import http.Method;
import controller.Controller;
import server.Request;
import server.Response;
import server.ServerApp;
import server.model.UserModel;

public class App  implements ServerApp {

    Controller controller=new Controller();
    Database db=new Database();
    UserModel um;

    public App() {

    }

    @Override
    public Response handleRequest(Request request) {

        if (request.getPathname().equals("/users") && request.getMethod() == Method.POST) {


            try {
                um = this.controller.getObjectMapper().readValue(request.getBody(),UserModel.class);

                return db.registerUser(um.getUsername(), um.getPassword());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }

        if (request.getPathname().equals("/sessions") && request.getMethod() == Method.POST){

            try {
                um = this.controller.getObjectMapper().readValue(request.getBody(),UserModel.class);

                db=new Database();

                return db.loginUser(um.getUsername(), um.getPassword());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }

        if (request.getPathname().equals("/stats") && request.getMethod() == Method.POST){

            try {
                um = this.controller.getObjectMapper().readValue(request.getBody(),UserModel.class);

                db=new Database();

                db.stats(um.getUsername());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }

        if (request.getPathname().equals("/scoreboard") && request.getMethod() == Method.GET){

            try {

                db=new Database();

                db.scoreboard();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        if (request.getPathname().equals("/changepw") && request.getMethod() == Method.POST){

            try {
                um = this.controller.getObjectMapper().readValue(request.getBody(),UserModel.class);

                db=new Database();

                return db.changePassword(um.getUsername(), um.getPassword(),um.getNewpassword(),um.getConfnewpassword());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }

        if (request.getPathname().equals("/win") && request.getMethod() == Method.POST){

            try {
                um = this.controller.getObjectMapper().readValue(request.getBody(),UserModel.class);

                db=new Database();

                db.win(um.getUsername());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }

        if (request.getPathname().equals("/loss") && request.getMethod() == Method.POST){

            try {
                um = this.controller.getObjectMapper().readValue(request.getBody(),UserModel.class);

                db=new Database();

                db.loss(um.getUsername());

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }


        return new Response(
            HttpStatus.BAD_REQUEST,
            ContentType.JSON,
            "[]"
        );
    }
}
