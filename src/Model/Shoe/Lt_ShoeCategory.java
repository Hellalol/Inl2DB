package Model.Shoe;

public class Lt_ShoeCategory {

    private int id;
    private Product shoe_id;
    private Category category_id;

    public Lt_ShoeCategory() {
    }

    public Lt_ShoeCategory(Product shoe_id, Category category_id) {
        this.shoe_id = shoe_id;
        this.category_id = category_id;
    }

    public Lt_ShoeCategory(int id, Product shoe_id, Category category_id) {
        this.id = id;
        this.shoe_id = shoe_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(Product shoe_id) {
        this.shoe_id = shoe_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
