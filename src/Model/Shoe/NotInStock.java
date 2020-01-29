package Model.Shoe;

import java.util.Date;

public class NotInStock {
    private Product product_id;
    private Date date;

    public NotInStock(Product product_id, Date dateTime) {
        this.product_id = product_id;
        this.date = dateTime;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Date getDateTime() {
        return date;
    }

    public void setDateTime(Date dateTime) {
        this.date = dateTime;
    }
}
