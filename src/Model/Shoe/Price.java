package Model.Shoe;

public class Price {

    private int id;
    private int price_amount;

    public Price(int price_amount){
        this.price_amount = price_amount;
    }

    public Price(int id, int price_amount) {
        this.id = id;
        this.price_amount = price_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice_amount() {
        return price_amount;
    }

    public void setPrice_amount(int price_amount) {
        this.price_amount = price_amount;
    }
}
