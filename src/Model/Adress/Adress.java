package Model.Adress;

public class Adress {

    private int id;
    private String adress_name;
    private int adress_number;
    private City city;
    private Postcode postcode;

    public Adress(String adress_name, int adress_number, City city, Postcode postcode) {
        this.adress_name = adress_name;
        this.adress_number = adress_number;
        this.city = city;
        this.postcode = postcode;
    }

    public Adress(int id, String adress_name, int adress_number, City city, Postcode postcode) {
        this.id = id;
        this.adress_name = adress_name;
        this.adress_number = adress_number;
        this.city = city;
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress_name() {
        return adress_name;
    }

    public void setAdress_name(String adress_name) {
        this.adress_name = adress_name;
    }

    public int getAdress_number() {
        return adress_number;
    }

    public void setAdress_number(int adress_number) {
        this.adress_number = adress_number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Postcode getPostcode() {
        return postcode;
    }

    public void setPostcode(Postcode postcode) {
        this.postcode = postcode;
    }
}
