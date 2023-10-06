package ait.product;

import ait.product.dao.Supermarket;
import ait.product.model.Food;
import ait.product.model.Product;

public class SupermarketAppl {
    public static void main(String[] args) {

        Supermarket kiosk = new Supermarket(10);
        kiosk.addProduct(new Product(1000, "Gift card", 25));
        kiosk.addProduct(new Product(8000, "Phone card", 13));
        kiosk.addProduct(new Food(2000, "Sosages", 5, "20.10.2023", false));
        kiosk.addProduct(new Food(3000, "Goat cheese", 3, "13.10.2030", true));
        kiosk.addProduct(new Food(4000, "Milk", 5, "18.10.2020", true));
        kiosk.addProduct(new Food(5000, "Yogurt", 1, "92.10.2020", true));
        kiosk.addProduct(new Food(000, " cheese", 3, "13.10.2030", true));
//        kiosk.addProduct(new Food(6000, "Milk", 5, "18.10.2020", true));
//        kiosk.addProduct(new Food(7000, "Milk", 5, "18.10.2020", true));
        kiosk.printAllProducts();

        kiosk.removeProduct(5000);
        kiosk.printAllProducts();
        System.out.println("===============================");
        kiosk.addProduct(new Food(6000, "Salad", 5, "18.10.2020", true));
        kiosk.printAllProducts();
        kiosk.updateProduct(2000,10);
        kiosk.printAllProducts();



    }
}
