package Model.Review;

public class Rating {

    private int id;
    private int rating_score;
    private String rating_text;

    public Rating() {
    }

    public Rating(int rating_score, String rating_text) {
        this.rating_score = rating_score;
        this.rating_text = rating_text;
    }

    public Rating(int id, int rating_score, String rating_text) {
        this.id = id;
        this.rating_score = rating_score;
        this.rating_text = rating_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating_score() {
        return rating_score;
    }

    public void setRating_score(int rating_score) {
        this.rating_score = rating_score;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }
}
