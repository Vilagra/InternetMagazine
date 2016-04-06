package levenko.com;

import levenko.com.Entites.Basket;
import levenko.com.Entites.Product;

/**
 * Created by Vilagra on 06.04.2016.
 */
public class Order {
    private Basket basket;
    int totalPrice;

    public Order(Basket basket){
        this.basket=basket;
        totalPrice = calculateOrder();
    }


    private int calculateOrder(){
        int total=0;
        for (Product product : basket.getProductsINBasket().keySet()) {
            total+=product.getPrice()*basket.getProductsINBasket().get(product);
        }
        return total;
    }

    public Basket getBasket() {
        return basket;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        basket.seeAllProductsInBasket();
        return "total price: "+totalPrice;
    }
}
