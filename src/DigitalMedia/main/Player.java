package DigitalMedia.main;

/**
 * The type Player.
 * Manages game players
 */
public class Player {
    /**
     * The Name.
     */
    public String name;
    /**
     * The Points.
     */
    public int points;

    /**
     * Instantiates a new Player.
     *
     * @param name   the name
     * @param points the points
     */
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Add points.
     * Method to calculate the points that the user will win.
     * It depends on the number of tries that the user needed to guess the riddle.
     *
     * @param tries the tries
     */
    public void addPoints(int tries){
        this.points += 30 - (tries - 1) * 10;
    }
}
