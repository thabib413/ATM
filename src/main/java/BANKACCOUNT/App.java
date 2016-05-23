package BANKACCOUNT;

import java.util.Random;

/**
 * Created by taiseerhabib on 5/18/16.
 */
public class App {

    public static void main(String[] args) {
        InputHandler currentInputHandler = new InputHandler();
        currentInputHandler.welcomeScreen();


        if(currentInputHandler.userInputWelcome == 9) {
            System.exit(0);
        }
    }
}
