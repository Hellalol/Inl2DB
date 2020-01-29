package Controller;

import Model.Adress.Adress;
import Model.Adress.City;
import Model.Adress.Postcode;
import Model.Customer;
import Model.Order.Order_item;
import Model.Order.Product_order;
import Model.Review.Rating;
import Model.Review.Review;
import Model.Shoe.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {

    private Properties pro = new Properties();

    public Repository() {
        try {
            pro.load(new FileInputStream("C:\\Users\\HB\\JavaPrograms\\testeee\\src\\loginfo.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Map<Integer, Product_order> mapProductOrderFromDb() throws SQLException {
        Map<Integer, Product_order> poHashMap = new HashMap<>();
        Map<Integer, Customer> customerHashMap = mapCustomerFromDb();
        Map<Integer, Order_item> order_itemMap = mapOrderItemFromDb();
        String sql = "select * from shoestoredb.product_order";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                poHashMap.put(rs.getInt("id"),
                        new Product_order(
                                customerHashMap.get(rs.getInt("customer_id")),
                                rs.getDate("date_of_order"),
                                order_itemMap)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poHashMap;
    }

    public Map<Integer, Order_item> mapOrderItemFromDb() throws SQLException {
        Map<Integer, Order_item> oIHashMap = new HashMap<>();
        Map<Integer, Product> productHashMap = mapProductFromDb();
        String sql = "select * from shoestoredb.order_item";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                oIHashMap.put(rs.getInt("id"),
                        new Order_item(
                                productHashMap.get(rs.getInt("product_id")),
                                rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oIHashMap;
    }

    public Map<Integer, Category> mapCategoriesFromDb() {
        Map<Integer, Category> categoryHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.category";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                categoryHashMap.put(rs.getInt("id"),
                        new Category(rs.getString("category_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryHashMap;
    }

    public Map<Integer, Lt_ShoeCategory> mapLtShoeCategoryFromDb() throws SQLException {
        Map<Integer, Lt_ShoeCategory> ltcategoryHashMap = new HashMap<>();
        Map<Integer, Product> productMap = mapProductFromDb();
        Map<Integer, Category> categoryMap = mapCategoriesFromDb();
        String sql = "select * from shoestoredb.lt_shoecategory";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ltcategoryHashMap.put(rs.getInt("id"),
                        new Lt_ShoeCategory(productMap.get(rs.getInt("shoe_id")),
                                            categoryMap.get(rs.getInt("category_id"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ltcategoryHashMap;
    }

    public Map<Integer, Brand> mapBrandsFromDb() {
        Map<Integer, Brand> brandHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.brand";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                brandHashMap.put(rs.getInt("id"),
                        new Brand(rs.getString("brand_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandHashMap;
    }

    public Map<Integer, Color> mapColorFromDb() {
        Map<Integer, Color> colorHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.color";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                colorHashMap.put(rs.getInt("id"),
                        new Color(rs.getString("color_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colorHashMap;
    }

    public Map<Integer, Size> mapSizeFromDb() {
        Map<Integer, Size> sizeHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.size";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                sizeHashMap.put(rs.getInt("id"),
                        new Size(rs.getInt("size_value")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizeHashMap;
    }

    public Map<Integer, Price> mapPriceFromDb() {
        Map<Integer, Price> priceHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.price";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                priceHashMap.put(rs.getInt("id"),
                        new Price(rs.getInt("price_amount")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priceHashMap;
    }

    public Map<Integer, Product> mapProductFromDb() throws SQLException {
        Map<Integer, Brand> allBrands = mapBrandsFromDb();
        Map<Integer, Color> allColors = mapColorFromDb();
        Map<Integer, Size> allSizes = mapSizeFromDb();
        Map<Integer, Price> allPrices = mapPriceFromDb();
        Map<Integer, Product> productHashMap = new HashMap<>();

        String sql = "select * from shoestoredb.product";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                productHashMap.put(rs.getInt("id"),
                        new Product(
                                allBrands.get(rs.getInt("brand_id")),
                                allColors.get(rs.getInt("color_id")),
                                allSizes.get(rs.getInt("size_id")),
                                allPrices.get(rs.getInt("price_id"))));

            }
            return productHashMap;
        }
    }

    public Map<Integer, Stock> mapStockFromDb() throws SQLException {
        Map<Integer, Stock> stockHashMap = new HashMap<>();
        Map<Integer,Product> productMap = mapProductFromDb();
        String sql = "select * from shoestoredb.stock";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                stockHashMap.put(rs.getInt("id"),
                        new Stock(productMap.get(rs.getInt("shoe_id")),
                                rs.getInt("stock_amount")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockHashMap;
    }

    public Map<Integer, NotInStock> mapNotInStockFromDb() throws SQLException {
        Map<Integer, NotInStock> notInStockHashMap = new HashMap<>();
        Map<Integer,Product> productMap = mapProductFromDb();
        String sql = "select * from shoestoredb.notinstock";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
             ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                notInStockHashMap.put(rs.getInt("id"),
                        new NotInStock(productMap.get(rs.getInt("product_id")),
                                rs.getTime("date_time")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notInStockHashMap;
    }

    public Map<Integer, Postcode> mapPostCodeFromDb() {
        Map<Integer, Postcode> postcodeHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.postcode";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                postcodeHashMap.put(rs.getInt("id"),
                        new Postcode(rs.getInt("postcode_number")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postcodeHashMap;
    }

    public Map<Integer, City> mapCityToFromDb() {
        Map<Integer, City> cityHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.city";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cityHashMap.put(rs.getInt("id"),
                        new City(rs.getString("city_name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityHashMap;
    }

    public Map<Integer, Adress> mapAdressFromDb() {
        Map<Integer, City> allCities = mapCityToFromDb();
        Map<Integer, Postcode> allPostCodes = mapPostCodeFromDb();
        Map<Integer, Adress> adressHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.adress";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                adressHashMap.put(rs.getInt("id"),
                        new Adress(
                                rs.getString("adress_name"),
                                rs.getInt("adress_number"),
                                allCities.get(rs.getInt("city_id")),
                                allPostCodes.get(rs.getInt("postcode_id"))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adressHashMap;
    }

    public Map<Integer, Customer> mapCustomerFromDb() {
        Map<Integer, Customer> customerHashMap = new HashMap<>();
        Map<Integer, Adress> allAdresses = mapAdressFromDb();
        String sql = "select * from shoestoredb.customer";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                customerHashMap.put(rs.getInt("id"),
                        new Customer(rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("password"),
                                allAdresses.get(rs.getInt("adress_id"))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerHashMap;
    }

    public Map<Integer, Rating> mapRatingFromDb() {
        Map<Integer, Rating> ratingHashMap = new HashMap<>();
        String sql = "select * from shoestoredb.rating";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ratingHashMap.put(rs.getInt("id"),
                        new Rating(rs.getInt("rating_score"),
                                rs.getString("rating_text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratingHashMap;
    }

    public Map<Integer, Review> mapReviewFromDb() throws SQLException {
        Map<Integer, Review> reviewHashMap = new HashMap<>();
        Map<Integer,Customer> customerMap = mapCustomerFromDb();
        Map<Integer,Product> productMap = mapProductFromDb();
        Map<Integer,Rating> ratingMap = mapRatingFromDb();

        String sql = "select * from shoestoredb.review";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                reviewHashMap.put(rs.getInt("id"),
                        new Review(customerMap.get(rs.getInt("customer_id")),
                                productMap.get(rs.getInt("product_id")),
                                ratingMap.get(rs.getInt("rating_id")),
                                rs.getString("review_comment"),
                                rs.getDate("date_of_review")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewHashMap;
    }

    public List<String> listOfProductsById(int customerId) {
        List<String> listofOrders = new ArrayList<>();
        String sql = "SELECT date_of_order as datee," +
                "brand_name as brand," +
                "color_name as color," +
                "size_value as size," +
                "price_amount as price," +
                "quantity as quantity " +
                "from product " +
                "inner join brand on product.brand_id = brand.id " +
                "inner join color on product.color_id = color.id " +
                "inner join size on product.size_id = size.id " +
                "inner join order_item on product.id = order_item.product_id " +
                "inner join price p on product.price_id = p.id " +
                "inner join product_order on order_item.order_id = product_order.id " +
                "inner join customer c on product_order.customer_id = c.id " +
                "where customer_id = ? " +
                "order by product_order.date_of_order";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listofOrders.add(rs.getDate("datee") +" " +
                        rs.getInt("quantity") + "x[" +
                        rs.getString("brand") + ", " +
                        rs.getString("color") + ", " +
                        rs.getString("size")+ ", " +
                        rs.getString("price") + "]");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listofOrders;
    }

    public void callAddToCart(int orderId, int customerId, int productID) {
        String sql = "call addToCart(?,?,?)";
        try (Connection con = DriverManager.getConnection(pro.getProperty("connectionstring"),
                pro.getProperty("name"),
                pro.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            stmt.setInt(2, customerId);
            stmt.setInt(3, productID);
            stmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getProductIdByBrandAndColorStringAndSize(String brand, String color, Integer size) throws SQLException {
        Map<Integer, Product> shoeMap = mapProductFromDb();

        String result = shoeMap.entrySet()
                .stream()
                .filter(x -> brand.toLowerCase().trim().equals(x.getValue().getBrand().getBrand_name().trim().toLowerCase()))
                .filter(x -> color.toLowerCase().trim().equals(x.getValue().getColor().getColor_name().trim().toLowerCase()))
                .filter(x -> size.equals(x.getValue().getSize().getSize_value()))
                .map(x-> x.getKey().toString())
                .collect(Collectors.joining())
                ;
        if(result.isEmpty())
            return "Sko hittades inte";
        else
            return result;
    }

    public void getAllProductsInStock() throws SQLException {
        mapStockFromDb().forEach((k,v)-> System.out.println(
                "Produkt [Brand: " +v.getShoe_id().getBrand().getBrand_name() + ", Color: " +
                        v.getShoe_id().getColor().getColor_name() + " Size: " +
                        v.getShoe_id().getSize().getSize_value() + "  Price: " +
                        v.getShoe_id().getPrice().getPrice_amount() + "] Stock [" +
                        v.getStock_amount() + "]"
        ));
    }

    public Integer getStockAmountForProduct(Integer prodId) throws SQLException {
        return mapStockFromDb().get(prodId).getStock_amount();
    }

    public List<String> getAllBrandsOfProduct() throws SQLException {
        List<String> brandlist = new ArrayList<>();
        mapBrandsFromDb().forEach((k,v)-> brandlist.add(v.getBrand_name()));
        return brandlist;
    }

    public List<String> getAllColorsOfProduct(){
        List<String> colorList = new ArrayList<>();
        mapColorFromDb().forEach((k,v)-> colorList.add(v.getColor_name()));
        return colorList;
    }

    public List<Integer> getAllSizesOfProduct(){
        List<Integer> sizeList = new ArrayList<>();
        mapSizeFromDb().forEach((k,v)-> sizeList.add(v.getSize_value()));
        return sizeList;
    }

    public List<Integer> getAllOrderIds() throws SQLException {
        List<Integer> listOfOrderIds = new ArrayList<>();
        mapProductOrderFromDb().forEach((k,v)-> listOfOrderIds.add(k));
        return listOfOrderIds;
    }

    public Customer getSpecificCustomerById(Integer userId){
        return mapCustomerFromDb().get(userId);
    }
}

