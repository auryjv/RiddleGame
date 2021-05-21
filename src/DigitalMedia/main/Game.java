package DigitalMedia.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * The type Game.
 * Game Class
 * This class will implement the main flow of the game.
 * It will be in charge of select a player between those that were previously added or
 * add a new one.
 */
public class Game {
    // List to store players
    final private ArrayList<Player> players;
    // Array to store books and movies items
    final private RiddleElement[] riddles;
    final private static int MAX_TRIES = 3;

    /**
     * Instantiates a new Game.
     */
    public Game() {
        this.players = new ArrayList <Player> ();
        this.riddles = new RiddleElement[10];

        this.riddles[0]= new Movies("Anna y Walter compran su primera casa juntos, una ganga que termina" +
                "por hacer cierto aquello de que las apariencias engañan", 10,"Esta casa es una ruina","1986",
                "Tom Hanks-Shelley Long","Comedia","Richard Benjamin","Universal");
        this.riddles[1]= new Movies("Cuando su hijo fallece durante el parto decide sustituirlo por un bebe que acaba de "+
                "perder a su madre en el mismo hospital, nefasta idea.",10,"La profecia", "1976","Gregory Peck-Harvey Stephens-Lee Remick",
                "Terror","Richar Donner","20th Century Fox");
        this.riddles[2]= new Movies("Aunque el tiempo los ha llevado por caminos muy diferentes Allie Hamilton y Noah Calhoun"+
                "está destinados a amarse y ni siquiera el olvido puede torcer su destino",5, "El diario de Noah","2004","Ryan gosling-Rachel McAdams",
                "Romántica","Nick Cassaretes","New Line Cinema");
        this.riddles[3]= new Movies("Marco Aurelio muere a manos de su hijo Cómodo y solo un general hispano se atreverá a desafiar al nuevo emperador, pagando muy caro su osadía.",
                5, "Gladiator", "2000", "Russell Crowe-Joaquin Phoenix", "Épica", "Ridley Scott", "Universal");
        this.riddles[4]= new Movies("Tarde o temprano, este león recordará quién es y cuál es su lugar",
                5, "El Rey León", "1994", "Simba-Mufasa", "Animación", "Roger Allers-Rod Mimkofs", "Walt Disney");
        this.riddles[5]= new Books("Un hotel en la montaña, en principio paracía un lugar ideal para acabar de escribir un libro", 5, "El Resplandor", "1977", "Jack Torrance", "Terror", "Stephen King");
        this.riddles[6]= new Books("Tiene muchos motivos para vengar los años que pasó injustamente encarcelado. Ninguno de los responsables quedará libre de castigo", 5, "El Conde de Montecristo", "1844", "Edmundo Dantés", "Aventuras", "Alejandro Dumas");
        this.riddles[7]= new Books("Blanca relata la historia de su familia desde la niñez de sus abuelos hasta el día de la muerte de su abuelo, incluyendo los cambios que se producen en el país en este tiempo", 8, "La casa de los espíritus", "1982", "Clara del Valle-Esteban, Clara y Blanca Trueba", "Realismo Mágico", "Isabela Yende");
        this.riddles[8]= new Books("Una detective privado se internará voluntariamente en un hospital psiquiátrico con el fin de descrubir a un asesino, pero ¿será la realidad tal y como se muestra?", 10, "Los Renglones Torcidos de Dios", "1979", "Alice Gould", "Thriller", "Torcuato Luca de Tena");
        this.riddles[9]= new Books("La muerte de un monje en una abadia de forma misteriosa, atraerá la atención de un franciscano y su discípulo", 5, "El Nombre de la Rosa", "1980", "Guillermo de Baskerville", "Misterio", "Umberto Eco");
    }

    /**
     * Get random riddle riddle element.
     * Get a random book or film from the array riddle elements
     *
     * @return the riddle element
     */
    public  RiddleElement getRandomRiddle(){
        Random rn =new Random();
        int riddleIndex = rn.nextInt(this.riddles.length);
        return this.riddles[riddleIndex];
    }

    /**
     * Get random movie movies.
     * In order to filter the array to obtain only movie objects.
     * I use a stream object that will help me in this task.
     *
     * @return the movies
     */
    public Movies getRandomMovie(){
        Object [] m = Arrays.stream(this.riddles).filter(i -> i instanceof Movies).toArray();
        Random rn =new Random();
        int riddleIndex = rn.nextInt(m.length);
        return (Movies) (m[riddleIndex]);
    }

    /**
     * Gets random book.
     * Retrieve a book from the riddle elements array
     *
     * @return the random book
     */
    public Books getRandomBook() {
        Object[] b = Arrays.stream(this.riddles).filter(i -> i instanceof Books).toArray();
        Random rn = new Random();
        int riddleIndex = rn.nextInt(b.length);
        return (Books) (b[riddleIndex]);
    }

    /**
     * Book mode.
     * Implements a game mode in which the user will try to guess a book
     *
     * @param p the p
     */
    public void bookMode(Player p){
        Books b = this.getRandomBook();
        this.play(p, b);
    }

    /**
     * Movie mode.
     * Implements a game mode in which the user will try to guess a movie
     *
     * @param p the p
     */
    public void movieMode(Player p){
        Movies m = this.getRandomMovie();
        this.play(p, m);
    }

    /**
     * Random mode.
     * Implements a game mode in which the user will try to guess a book or a movie randomly
     *
     * @param p the p
     */
    public void randomMode(Player p){
        RiddleElement r = this.getRandomRiddle();
        this.play(p, r);
    }

    /*
        Implements the game flow
    */
    private void play(Player p, RiddleElement e) {
        boolean win = false;
        int tries = 0;
        Scanner sc = new Scanner(System.in);
        String answer;
        e.resetClueIndex();
        do {
            System.out.println("Clue: " + e.getClue());
            System.out.print("Your answer is: ");
            answer = sc.nextLine();
            // Check if the answer is right
            win = e.checkTitle(answer);
            if (!win) {
                System.out.println("Ohh, you're wrong!!");
            }
            tries++;
            if (!win && tries < MAX_TRIES) {
                System.out.println("I'll give you another clue...");
            }
        } while(!win && tries < MAX_TRIES);
        if (win) {
            System.out.println("Congratulations, you've won!");
            System.out.println();
            p.addPoints(tries);
            System.out.println("Your score is: " + p.getPoints());
        } else {
            System.out.println("I'm sorry, you've ran out of chances");
            System.out.println("The right answer is: " + e.getTitle());
        }
        sc.nextLine();
    }
    /*
        Creates a new player and store it in the array list
    */
    private Player newPlayer() {
        Player p = null;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("Player name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        p = new Player(name.trim(), 0);
        this.players.add(p);
        return p;
    }

    /*
        It shows a menu containing all players.
        The user will choose one of them to continue playing
    */
    private Player getPlayer() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        if (this.players.size() == 0) {
            System.out.print("No players found ");
            sc.nextLine();
            return null;
        }

        System.out.println();
        for (int i = 0; i < this.players.size(); i++) {
            Player p = this.players.get(i);
            System.out.printf("%d) %s  -> %d points\n", i + 1, p.getName(), p.getPoints());
        }
        System.out.println();
        System.out.println("0) Exit");
        System.out.println();
        System.out.println();
        System.out.print("Select one: ");
        int index = sc.nextInt();
        if (index == 0 || index > this.players.size()) return null;
        return this.players.get(index - 1);
    }

    /**
     * Select player player.
     * Shows a menu to allow the user to choose between select a player already
     * registered or create a new one.
     *
     * @return the player
     */
    public Player selectPlayer() {
        Player p = null;
        boolean userSelected = false;
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("1) New player");
            System.out.println("2) Select player");
            System.out.println();
            System.out.println("0) Exit");
            System.out.println();
            System.out.println();
            System.out.print("Choose option: ");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            switch (option) {
                case "1" -> {
                    p = this.newPlayer();
                    userSelected = true;
                }
                case "2" -> {
                    p = this.getPlayer();
                    userSelected = p != null;
                }
                case "0" -> {
                    p = null;
                    userSelected = true;
                }
            }
        } while (!userSelected);
        return p;
    }
}

