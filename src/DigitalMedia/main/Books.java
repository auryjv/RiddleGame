package DigitalMedia.main;

/**
 * The type Books.
 */
public class Books extends RiddleElement {
    private String author;

    /**
     * Instantiates a new Books.
     *
     * @param description    the description
     * @param points         the points
     * @param title          the title
     * @param year           the year
     * @param mainCharacters the main characters
     * @param genre          the genre
     * @param author         the author
     */
    public Books(String description, int points, String title,
                 String year, String mainCharacters, String genre,
                 String author) {
        super(description, points, title, year, mainCharacters, genre);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                super.toString() +
                '}';
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getClue() {
        String clue = "";

        switch (this.getClueIndex()) {
            case 0:
                clue = this.getDescription();
                break;
            case 1:
                clue =  "El año de publicación del libro fue " + this.getYear();
                break;
            case 2:
                clue = "El/los autor/es son  " + this.getAuthor();
                break;
            case 3:
                clue = "El/los  protagonista/s es/son " + this.getMainCharacters();
                break;
            case 4:
                clue = "El género del libro es  " + this.getGenre();
                break;
        }
        this.increaseClueIndex();
        return clue;
    }
}
