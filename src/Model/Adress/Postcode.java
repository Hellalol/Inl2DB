package Model.Adress;

public class Postcode {

    private int id;
    private int postcode_number;


    public Postcode(){}

    public Postcode(int postcode_number) {
        this.postcode_number = postcode_number;
    }

    public Postcode(int id, int postcode_number) {
        this.id = id;
        this.postcode_number = postcode_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostcode_number() {
        return postcode_number;
    }

    public void setPostcode_number(int postcode_number) {
        this.postcode_number = postcode_number;
    }
}
