package View;

import Controller.StateController;

import java.sql.SQLException;
import java.util.List;

public class View {

    public static void main(String[] args) throws SQLException {
        StateController s = new StateController();

    }

    public void integerPrint(Integer number) {
        System.out.println(number);
    }

    public void listPrintInt(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void listPrint(List<String> message) {
        System.out.println(message);
    }

    public void stringPrint(String message) {
        System.out.println(message);
    }
}


