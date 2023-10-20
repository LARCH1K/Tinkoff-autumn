package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hangman {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void run() {
        while (startGame(SCANNER)) {
            LOGGER.info("\nTo give up, send '!giveUp'");
            Session session = new Session(new RightDictionary());
            GuessResult gameState = tryGuess(session, SCANNER);
            while (true) {
                if (gameState.getClass() == GuessResult.GiveUp.class) {
                    LOGGER.info(gameState.message(session));
                    break;
                }
                session.printState();
                LOGGER.info(gameState.message(session));
                if (gameState.getClass() == GuessResult.Win.class || gameState.getClass() == GuessResult.Defeat.class) {
                    break;
                }
                gameState = tryGuess(session, SCANNER);
            }
        }
    }

    boolean startGame(Scanner scanner) {
        while (true) {
            LOGGER.info("\nTo start playing, send '!start'\n"
                + "To exit, send '!exit'");
            String startOrEnd = scanner.nextLine();
            if (startOrEnd.equalsIgnoreCase("!start")) {
                return true;
            }
            if (startOrEnd.equalsIgnoreCase("!exit")) {
                return false;
            }
        }
    }

    GuessResult tryGuess(Session session, Scanner scanner) {
        while (true) {
            LOGGER.info("\nGuess a letter: ");
            String input = scanner.nextLine();
            if (input.matches("[a-z]|[A-Z]")) {
                return session.guess(input.toLowerCase().charAt(0));
            }
            if (input.equalsIgnoreCase("!giveUp")) {
                return new GuessResult.GiveUp();
            }
        }
    }
}
