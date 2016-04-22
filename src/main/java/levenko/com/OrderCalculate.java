package levenko.com;

import levenko.com.Entites.Basket;
import levenko.com.Entites.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vilagra on 06.04.2016.
 */
public class OrderCalculate {
    public Map<Product, Integer> getProductsInBasket() {
        return ProductsInBasket;
    }

    private Map<Product, Integer> ProductsInBasket = new HashMap<>();
    int totalPrice;

    public OrderCalculate(Basket basket) {
        this.ProductsInBasket = basket.getProductsINBasket();
        totalPrice = calculateOrder();
    }


    private int calculateOrder() {
        int total = 0;
        for (Map.Entry<Product, Integer> productIntegerEntry : ProductsInBasket.entrySet()) {
            total += productIntegerEntry.getKey().getPrice() * productIntegerEntry.getValue();
        }

        return total;
    }


    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        System.out.println(ProductsInBasket);
        return "total price: " + totalPrice;
    }
}
