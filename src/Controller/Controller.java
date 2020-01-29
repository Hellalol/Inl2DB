package Controller;

import Model.Customer;
import Model.Shoe.Product;
import Model.Shoe.Stock;
import View.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    Repository repo = new Repository();
    List<Product> currentCart = new ArrayList<>();
    View view = new View();


    public void printAllProductsInStock() throws SQLException {
        repo.getAllProductsInStock();
    }

    public void addToCurrentCart(Integer productID) throws SQLException {
        Map<Integer, Stock> product_orderMap = repo.mapStockFromDb();
        if(product_orderMap.get(productID).getStock_amount() == 0)
            view.stringPrint("The current product is out of stock.");
        else
            currentCart.add(new Product(product_orderMap.get(productID).getShoe_id().getBrand(),
                product_orderMap.get(productID).getShoe_id().getColor(),
                product_orderMap.get(productID).getShoe_id().getSize(),
                product_orderMap.get(productID).getShoe_id().getPrice()));
    }

    public void clearCurrentCart() {
        currentCart.clear();
        view.stringPrint("Cart cleared!");
    }

    public void removeLastAddedCartItem() {
        currentCart.remove(currentCart.size() - 1);

    }

    public List<String> getIdForEachItemInCart() throws SQLException {
        List<String> result = new ArrayList<>();
        for (Product product : currentCart) {
            result.add(repo.getProductIdByBrandAndColorStringAndSize(
                    product.getBrand().getBrand_name(),
                    product.getColor().getColor_name(),
                    product.getSize().getSize_value()));
        }
        return result;
    }

    public void feedCartIntoOrder(Integer currentCustomer) throws SQLException {
        List<String> result = getIdForEachItemInCart();
        List<Integer> intRes = new ArrayList<>();
        for (String s : result) intRes.add(Integer.valueOf(s));

        for (int i = 0; i < getIdForEachItemInCart().size(); i++) {
            makeOrder(currentCustomer, intRes.get(i));
        }

    }

    public void makeOrder(Integer customerID, Integer productID) throws SQLException {
        repo.callAddToCart(getNextOrderId(), customerID, productID);
    }

    public void printCurrentCart() {
        for (Product product : currentCart) {
            view.stringPrint("B: " + product.getBrand().getBrand_name() + " C: " +
                    product.getColor().getColor_name() + " S: " +
                    product.getSize().getSize_value() + " P:" +
                    product.getPrice().getPrice_amount());
        }
    }

    public List<String> listOfProductById(Integer customerId) {
        return repo.listOfProductsById(customerId);
    }

    public String getUsernameFromId(Integer id) {
        Map<Integer, Customer> cuss = repo.mapCustomerFromDb();
        return cuss.get(id).getFirst_name();
    }

    public void printBrandList() throws SQLException {
        view.listPrint(repo.getAllBrandsOfProduct());
    }

    public void printSizeList() {
        view.listPrintInt(repo.getAllSizesOfProduct());
    }

    public void printColorList() {
        view.listPrint(repo.getAllColorsOfProduct());
    }

    public Customer getSpecificCustomerById(Integer integer) {
        return repo.getSpecificCustomerById(integer);
    }

    public Integer getStockAmountForProduct(Integer productID) throws SQLException {
        return repo.getStockAmountForProduct(productID);
    }

    public Integer getProductIdByBrandColorID(String brand, String color, Integer size) throws SQLException, NumberFormatException {
        String idString = repo.getProductIdByBrandAndColorStringAndSize(brand, color, size);
        return Integer.parseInt(idString);

    }

    public String seeIfUserNameAndPasswordsMatch(String username, String password) throws SQLException {
        Map<Integer, Customer> fullCustomerList = repo.mapCustomerFromDb();

        String result = fullCustomerList.entrySet().stream()
                .filter(x -> username.toLowerCase().equals(x.getValue().getFirst_name().toLowerCase().trim()))
                .filter(x -> password.equals(x.getValue().getPassword().trim()))
                .map(x -> x.getKey().toString())
                .collect(Collectors.joining());

        if (result.isEmpty()) {
            return "Access Denied";
        } else
            return result;
    }

    public Integer getNextOrderId() throws SQLException {
        return repo.getAllOrderIds().get(repo.getAllOrderIds().size() - 1) + 1;
    }


    public static void main(String[] args) throws SQLException {
        Controller cont = new Controller();
        System.out.println(cont.getStockAmountForProduct(3));
    }
}
