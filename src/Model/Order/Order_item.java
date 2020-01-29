package Model.Order;

import Model.Shoe.Product;

public class Order_item {

    private Product produktId;
    private int quantity;

    public Order_item(Product produktId, int quantity) {
        this.produktId = produktId;
        this.quantity = quantity;
    }

    public Product getProduktId() {
        return produktId;
    }

    public void setProduktId(Product produktId) {
        this.produktId = produktId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
