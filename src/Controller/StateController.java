package Controller;

import View.View;

import java.sql.SQLException;
import java.util.Scanner;


public class StateController {

    private static final int LOGIN = 1;
    private static final int MAIN_MENU = 2;
    private static final int CHECK_ORDERS = 3;
    private static final int ORDER_MENU = 4;
    private static final int ADDTOCART = 5;
    private static final int VIEWCART = 6;
    private static final int CLEAR_CART = 7;
    private static final int REMOVE_LAST_ENTRY = 8;
    private static final int VIEWSTOCK = 9;
    private static final int PLACEORDER = 10;

    public StateController() throws SQLException {
        View view = new View();

        Controller controller = new Controller();
        int currentState = LOGIN;
        int userId = 0;
        Scanner userInputFromConsole = new Scanner(System.in);

        while (true) {
            if (currentState == LOGIN) {

                view.stringPrint("Please enter your username.");
                String username = userInputFromConsole.next();

                view.stringPrint("Please enter your password.");
                String password = userInputFromConsole.next();

                String user = controller.seeIfUserNameAndPasswordsMatch(username, password);
                if (user.startsWith("Acc")) {
                    view.stringPrint("Wrong username or password");
                    System.exit(0);
                } else {
                    userId = Integer.parseInt(user);
                    view.stringPrint("login successful");
                }

                currentState = MAIN_MENU;

            } else if (currentState == MAIN_MENU) {

                view.stringPrint("Hello " + controller.getUsernameFromId(userId) + " what would you like to do today?\n" +
                        "1. Order\n2. Check your orders\n3. Log out");

                int choice1 = userInputFromConsole.nextInt();

                if (choice1 == 1)
                    currentState = ORDER_MENU;
                else if (choice1 == 2)
                    currentState = CHECK_ORDERS;
                else if (choice1 == 3) {
                    view.stringPrint("logging out");
                    System.exit(0);
                }

            } else if (currentState == CHECK_ORDERS) {

                view.stringPrint("Checking orders");
                controller.listOfProductById(userId).forEach(System.out::println);

                currentState = MAIN_MENU;

            } else if (currentState == ORDER_MENU) {

                view.stringPrint("What would you like to do?\n" +
                        "1. add to cart\n" +
                        "2. View cart\n" +
                        "3. Clear current order\n" +
                        "4. Remove last entry in current cart\n" +
                        "5. View Stock\n" +
                        "6. Place Order");

                int choice = userInputFromConsole.nextInt();

                if (choice == 1)
                    currentState = ADDTOCART;
                else if (choice == 2)
                    currentState = VIEWCART;
                else if (choice == 3)
                    currentState = CLEAR_CART;
                else if (choice == 4)
                    currentState = REMOVE_LAST_ENTRY;
                else if (choice == 5)
                    currentState = VIEWSTOCK;
                else if (choice == 6)
                    currentState = PLACEORDER;
                else
                    System.exit(0);

            } else if (currentState == ADDTOCART) {

                view.stringPrint("Which product would you like to add to the cart?\nSelect Brand");
                controller.printBrandList();
                String userinput1 = userInputFromConsole.next().toLowerCase().trim().replace(",", "");

                view.stringPrint("Select Color");
                controller.printColorList();
                String userinput2 = userInputFromConsole.next().toLowerCase().trim().replace(",", "");

                view.stringPrint("which size would you like on the shoe?");
                controller.printSizeList();

                String userinput3 = userInputFromConsole.next();
                Integer sizeInput = Integer.parseInt(userinput3);

                Integer productIDInteger = controller.getProductIdByBrandColorID(userinput1, userinput2, sizeInput);

                controller.addToCurrentCart(productIDInteger);

                currentState = ORDER_MENU;

            } else if (currentState == VIEWCART) {

                if (controller.currentCart.isEmpty()) {
                    view.stringPrint("The current cart is empty");
                } else {
                    view.stringPrint("Current cart");
                    controller.printCurrentCart();
                }
                currentState = ORDER_MENU;

            } else if (currentState == CLEAR_CART) {

                if(controller.currentCart.isEmpty())
                    view.stringPrint("The cart is empty, cant remove anything!");
                else
                    controller.clearCurrentCart();
                currentState = ORDER_MENU;

            } else if (currentState == VIEWSTOCK) {

                controller.printAllProductsInStock();
                currentState = ORDER_MENU;

            }else if(currentState == REMOVE_LAST_ENTRY){

                if(controller.currentCart.isEmpty())
                    view.stringPrint("The cart is empty, cant remove anything!");
                else
                    controller.removeLastAddedCartItem();
                currentState = ORDER_MENU;

            } else if (currentState == PLACEORDER) {

                controller.feedCartIntoOrder(userId);
                view.stringPrint("Order placed!");
                currentState = MAIN_MENU;

            }
        }
    }
}
