package Model;

import Model.Adress.Adress;

public class Customer {
    private int id;
    private String first_name;
    private String last_name;
    private String password;
    private Adress adress;

    public Customer(int id, String first_name, String last_name, String password, Adress adress) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.adress = adress;
    }

    public Customer(String first_name, String last_name, String password, Adress adress) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }


}
