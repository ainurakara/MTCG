package at.fhtw.mtcg.model;

import at.fhtw.httpserver.server.Server;

import java.io.IOException;
import java.util.Scanner;

public class GameBoard {

    public void start(){

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your username: ");
    String username = scanner.nextLine();

    System.out.print("Enter your password: ");
    String password = scanner.nextLine();

    if (authenticate(username, password)) {


    } else {
        System.out.println("Authentication failed. Invalid username or password.");
    }

        scanner.close();
}
    private static boolean authenticate(String username, String password) {
        //if does not exist, add and return true;
        //otherwise check if username and password are equal to data in db
        return username.equals(password);
    }

}
