package Model.Adress;

public class City {

    private int id;
    private String city_name;

    public City(String city_name) {
        this.city_name = city_name;
    }

    public City(int id, String city_name) {
        this.id = id;
        this.city_name = city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
