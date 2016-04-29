package levenko.com.Entites;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class Order {
    private int id=0;
    private Date date;
    private Map<Product,Integer> productsAndCounts = new HashMap<>();

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Product, Integer> getProductsAndCounts() {
        return productsAndCounts;
    }

    public void setProductsAndCounts(Map<Product, Integer> productsAndCounts) {
        this.productsAndCounts = productsAndCounts;
    }

    public void addProductWithAmount(Product product, int amount){
        productsAndCounts.put(product,amount);

    }

    @Override
    public String toString() {
        return "Order{" +
                ", date=" + date +
                ", productsAndCounts=" + productsAndCounts +
                '}';
    }
}
