package levenko.com.Entites;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vilagra on 05.04.2016.
 */
public class Basket {
    private Map<Product,Integer> productsINBasket = new LinkedHashMap<Product, Integer>();

    public Map<Product, Integer> getProductsINBasket() {
        return productsINBasket;
    }


    public void addProductInBasket(Product product,Integer amount){
        if(productsINBasket.containsKey(product)){
            productsINBasket.put(product,productsINBasket.get(product)+amount);
        }
        else{
            productsINBasket.put(product,amount);
        }
    }

    public void seeAllProductsInBasket(){
        for (Map.Entry set: productsINBasket.entrySet()) {
            System.out.println(set.getKey() + " ammount: "+ set.getValue());
        }
        productsINBasket.entrySet();
    }

    public void cleanOutBasket(){
        productsINBasket = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productsINBasket=" + productsINBasket +
                '}';
    }
}
