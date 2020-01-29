package Model.Shoe;

public class Stock {
    private Product shoe_id;
    private int stock_amount;

    public Stock(Product shoe_id, int stock_amount) {
        this.shoe_id = shoe_id;
        this.stock_amount = stock_amount;
    }

    public Product getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(Product shoe_id) {
        this.shoe_id = shoe_id;
    }

    public int getStock_amount() {
        return stock_amount;
    }

    public void setStock_amount(int stock_amount) {
        this.stock_amount = stock_amount;
    }
}
