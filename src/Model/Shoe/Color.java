package Model.Shoe;

public class Color {

    private int id;
    private String color_name;

    public Color(String color_name){
        this.color_name = color_name;
    }

    public Color(int id, String color_name) {
        this.id = id;
        this.color_name = color_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
}
