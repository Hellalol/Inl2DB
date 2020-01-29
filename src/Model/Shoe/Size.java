package Model.Shoe;

public class Size {

    private int id;
    private int size_value;

    public Size(int size_value) {
        this.size_value = size_value;
    }

    public Size(int id, int size_value) {
        this.id = id;
        this.size_value = size_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize_value() {
        return size_value;
    }

    public void setSize_value(int size_value) {
        this.size_value = size_value;
    }
}
