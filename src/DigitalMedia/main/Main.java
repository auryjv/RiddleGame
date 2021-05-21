package DigitalMedia.main;

import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The constant MIN_RIDDLES_PER_USER.
     */
    public static int MIN_RIDDLES_PER_USER = 4;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Player p;
        Game g = new Game();
        Scanner sc = new Scanner(System.in);
        String option;
        boolean quit = false;
        int nRiddlesTried = 0;
        do {
            // Select a player to play
            p = g.selectPlayer();
            if (p != null) {
                nRiddlesTried = 0;
                do {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Hello " + p.getName() + "!");
                    System.out.println();
                    System.out.println();
                    System.out.println("1.Book Mode");
                    System.out.println("2.Movie Mode");
                    System.out.println("3.Random Mode");
                    System.out.println();
                    if (nRiddlesTried == MIN_RIDDLES_PER_USER) {
                        System.out.println(p.getName() + "! you reached the minimum number of tries to quit the game");
                        System.out.println("Now you can exit this game or continue playing.");
                    }
                    if (nRiddlesTried >= MIN_RIDDLES_PER_USER) {
                        System.out.println("0. Exit");
                        System.out.println();
                    }
                    System.out.println();
                    System.out.print("Choose an option: ");

                    option = sc.nextLine();
                    // Select game mode
                    switch (option) {
                        case "1" -> g.bookMode(p);
                        case "2" -> g.movieMode(p);
                        case "3" -> g.randomMode(p);
                        case "0" -> quit = true;
                    }
                    nRiddlesTried++;
                } while (!quit);
                quit = false;
            } else {
                quit = true;
            }
        } while (!quit);
        System.out.println("Good bye!");
    }
}


