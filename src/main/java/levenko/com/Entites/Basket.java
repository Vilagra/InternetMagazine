package levenko.com.Entites;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Vilagra on 05.04.2016.
 */
public class Basket {
    private Map<Product,Integer> productsINBasket = new LinkedHashMap<Product, Integer>();

    public Map<Product, Integer> getProductsINBasket() {
        return productsINBasket;
    }

    public void setProductsINBasket(Map<Product, Integer> productsINBasket, Product p, int amount) {
        this.productsINBasket = productsINBasket;
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
        for (Product product : productsINBasket.keySet()) {
            System.out.println(product.getName() + " ammount: "+ productsINBasket.get(product));
        }

    }

    @Override
    public String toString() {
        return "Basket{" +
                "productsINBasket=" + productsINBasket +
                '}';
    }
}
