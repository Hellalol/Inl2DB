package Model.Shoe;

public class Product {
    private int id;
    private Brand brand;
    private Color color;
    private Size size;
    private Price price;

    public Product(Brand brand, Color color, Size size, Price price) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Product(int id, Brand brand, Color color, Size size, Price price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

}
