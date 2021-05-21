package DigitalMedia.main;

/**
 * The type Riddle element.
 * Abstract class which will be inherited from Movies and Books classes
 */
public abstract class RiddleElement {
    /**
     * The Description.
     */
    protected String description;
    /**
     * The Points.
     */
    protected int points;
    /**
     * The Title.
     */
    protected String title;
    /**
     * The Year.
     */
    protected String year;
    /**
     * The Main characters.
     */
    protected String mainCharacters;
    /**
     * The Genre.
     */
    protected String genre;
    /**
     * The Clue index.
     */
    protected int clueIndex;

    /**
     * Instantiates a new Riddle element.
     *
     * @param description    the description
     * @param points         the points
     * @param title          the title
     * @param year           the year
     * @param mainCharacters the main characters
     * @param genre          the genre
     */
    public RiddleElement(String description, int points, String title,
                         String year, String mainCharacters, String genre) {
        this.description = description;
        this.points = points;
        this.title = title;
        this.year = year;
        this.mainCharacters = mainCharacters;
        this.genre = genre;
        this.clueIndex = 0;
    }

    /**
     * Gets clue index.
     *
     * @return the clue index
     */
    public int getClueIndex() {
        return clueIndex;
    }

    /**
     * Increase clue index.
     */
    public void increaseClueIndex() {
        this.clueIndex++;
    }

    /**
     * Reset clue index.
     */
    public void resetClueIndex() {
        this.clueIndex = 0;
    }

    /**
     * Check title boolean.
     *
     * @param title the title
     * @return the boolean
     */
    public boolean checkTitle (String title) {
        return this.getTitle().equalsIgnoreCase(title.trim());
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Gets main characters.
     *
     * @return the main characters
     */
    public String getMainCharacters() {
        return mainCharacters;
    }

    /**
     * Sets main characters.
     *
     * @param mainCharacters the main characters
     */
    public void setMainCharacters(String mainCharacters) {
        this.mainCharacters = mainCharacters;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Subtract points int.
     *
     * @param points the points
     * @return the points int
     */
    public int subtractPoints (int points){
        return this.points - points;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Gets clue.
     * Abstract method that will be implemented en subclasses
     *
     * @return the clue
     */
    public abstract String getClue();

    public String toString() {
        return
                ", description='" + description + '\'' +
                ", points=" + points +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", mainCharacters='" + mainCharacters + '\'' +
                ", genre='" + genre + '\'' ;
    }
}
