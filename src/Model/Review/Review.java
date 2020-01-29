package Model.Review;

import Model.Customer;
import Model.Shoe.Product;

import java.util.Date;

public class Review {

    private int id;
    private Customer customer_id;
    private Product product_id;
    private Rating rating_id;
    private String review_comment;
    private Date date_of_review;

    public Review() {
    }



    public Review(Customer customer_id, Product product_id, Rating rating_id, String review_comment, Date date_of_review) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.rating_id = rating_id;
        this.review_comment = review_comment;
        this.date_of_review = date_of_review;
    }

    public Review(int id, Customer customer_id, Product product_id, Rating rating_id, String review_comment, Date date_of_review) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.rating_id = rating_id;
        this.review_comment = review_comment;
        this.date_of_review = date_of_review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Rating getRating_id() {
        return rating_id;
    }

    public void setRating_id(Rating rating_id) {
        this.rating_id = rating_id;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public Date getDate_of_review() {
        return date_of_review;
    }

    public void setDate_of_review(Date date_of_review) {
        this.date_of_review = date_of_review;
    }
}
