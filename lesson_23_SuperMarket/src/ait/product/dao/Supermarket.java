package ait.product.dao;

import ait.product.model.Product;

import java.util.function.Predicate;

public class Supermarket {

    private Product[] products;
    private int quantity;

    public Supermarket(int capacity) {
        products = new Product[capacity];
    }

    public boolean addProduct(Product product) {
        if (product == null || quantity == products.length || findProduct(product.getBarcode()) != null) {
            return false;
        }
        products[quantity] = product;
        quantity++;
        return true;
    }

    public Product findProduct(long barcode) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                return products[i];
            }
        }
        return null;
    }

    public Product updateProduct(long barcode, double price) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                products[i].setPrice(price);
            }
        }
        return null;
    }

    public boolean removeProduct(long barcode) {
        Product temp;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                temp = products[i];
                products[i] = products[quantity - 1];
                products[quantity - 1] = null;
                quantity--;
                System.out.println("===Product " +"'"+ temp.getName() + "'"+" was removed===");
            }
        }
        return false;
    }

    public void printAllProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
    }
}

/*
public boolean removeProduct(long barcode) {
         Product temp;
        for (int i = 0; i < products.length; i++) {
            if(products[i] == null || products[i].getBarcode() != barcode){
               return false;
            }else if(products[i].getBarcode() == barcode){
                temp = products[i];
                products[i] = products[quantity -1];
                products[quantity -1] = null;
                quantity--;
                System.out.println("===Product " +"'"+ temp.getName() + "'"+" was removed===");
            }
        }
        return true;
    }
 */