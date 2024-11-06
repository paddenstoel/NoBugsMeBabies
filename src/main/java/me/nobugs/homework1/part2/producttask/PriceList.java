package me.nobugs.homework1.part2.producttask;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    HashMap<String, Double> productList = new HashMap<>();

    public void addProduct(Product product) {
        productList.put(product.getProductName(), product.getProductPrice());
    }

    public void updatePrice(String productName, double newPrice) {
        if (productList.containsKey(productName)) {
            productList.put(productName, newPrice);
            System.out.println("Цена товара " + productName + " обновлена на " + newPrice);
        } else {
            System.out.println("Товар с названием " + productName + " не найден.");
        }
    }

    public Double getPrice(String productName) {
        return productList.getOrDefault(productName, null);
    }

    public void printPriceList() {
        if (productList.isEmpty()) {
            System.out.println("Список товаров пуст.");
        } else {
            for (Map.Entry<String, Double> entry : productList.entrySet()) {
                System.out.println("Товар: " + entry.getKey() + ", Цена: " + entry.getValue());
            }
        }
    }
}
