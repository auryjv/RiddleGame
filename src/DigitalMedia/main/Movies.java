package DigitalMedia.main;

/**
 * The type Movies.
 */
public class Movies extends RiddleElement {
    private String director;
    private String studios;

    /**
     * Instantiates a new Movies.
     *
     * @param description    the description
     * @param points         the points
     * @param title          the title
     * @param year           the year
     * @param mainCharacters the main characters
     * @param genre          the genre
     * @param director       the director
     * @param studios        the studios
     */
    public Movies(String description, int points, String title,
                  String year, String mainCharacters, String genre,
                  String director,String studios) {
        super(description, points, title, year, mainCharacters, genre);
        this.director = director;
        this.studios = studios;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets studios.
     *
     * @return the studios
     */
    public String getStudios() {
        return studios;
    }

    /**
     * Sets studios.
     *
     * @param studios the studios
     */
    public void setStudios(String studios) {
        this.studios = studios;
    }

    @Override
    public String toString() {
        return "Movie {" +
                "director='" + director + '\'' +
                ", studios='" + studios + '\'' +
                super.toString() +
                '}';

    }

    @Override
    public String getClue() {
        String clue = "";

        switch (this.getClueIndex()){
            case 0:
                clue = this.getDescription();
                break;
            case 1:
                clue =  "El año de su estreno fue " + this.getYear();
                break;
            case 2:
                clue = "El/los protagonista/s  es/son   " + this.getMainCharacters();
                break;
            case 3:
                clue = "Los estudios que produjeron su rodaje son " + this.getStudios();
                break;
            case 4:
                clue = "El género de la película es " + this.getGenre();
                break;
            case 5:
                clue = "El director de la película es  " + this.getDirector();
                break;
        }
        this.increaseClueIndex();
        return clue;
    }
}
