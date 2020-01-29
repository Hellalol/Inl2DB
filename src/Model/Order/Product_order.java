package Model.Order;

import Model.Customer;

import java.util.Date;
import java.util.Map;

public class Product_order {

    private Customer customer_id;
    private Date date_of_order;
    private Map<Integer,Order_item> order_itemMap;


    public Map<Integer, Order_item> getOrder_itemMap() {
        return order_itemMap;
    }

    public void setOrder_itemMap(Map<Integer, Order_item> order_itemMap) {
        this.order_itemMap = order_itemMap;
    }

    public Product_order(Customer customer_id, Date date_of_order, Map<Integer, Order_item> order_itemMap) {
        this.customer_id = customer_id;
        this.date_of_order = date_of_order;
        this.order_itemMap = order_itemMap;
    }

    public Product_order(Customer customer_id, Date date_of_order) {
        this.customer_id = customer_id;
        this.date_of_order = date_of_order;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate_of_order() {
        return date_of_order;
    }

    public void setDate_of_order(Date date_of_order) {
        this.date_of_order = date_of_order;
    }
}
