package Model.Shoe;

public class Category {

    private int id;
    private String category_type;

    public Category(String category_type) {
        this.category_type = category_type;
    }

    public Category(int id, String category_type) {
        this.id = id;
        this.category_type = category_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }
}
