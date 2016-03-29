package levenko.com;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by Vilagra on 28.03.2016.
 */
public class Basket {
    private Set<Product> setAllProducts;
    private Map<Product,Integer> productsINBasket = new LinkedHashMap<Product, Integer>();

    public Basket(Set<Product> setAllProducts) {
        this.setAllProducts = setAllProducts;
    }

    public void setProductsINBasket(Map<Product, Integer> productsINBasket,Product p,int amount) {
        this.productsINBasket = productsINBasket;
    }

    public Map<Product, Integer> getProductsINBasket() {
        return productsINBasket;
    }

    public Set<Product> getSetAllProducts() {
        return setAllProducts;
    }



    public void workWithBasket(){
        String flag ="";
        Scanner sc= new Scanner(System.in);
        while(!flag.equals("4")) {
            System.out.println();
            System.out.println("Press '1' if you want to see list of products");
            System.out.println("Press '2' if you want to add products in basket");
            System.out.println("Press '3' if you want to see what stored in your basket");
            System.out.println("Press '4' if you want to make order");
            System.out.println("Make your choise:");
            flag = sc.next();
            switch(flag){
                case "1":
                    seeAllProducts();
                    break;
                case "2":
                    System.out.println("Choice product:");
                    seeAllProducts();
                    System.out.print("Enter id: ");
                    Integer id = sc.nextInt();
                    System.out.print("Enter amount: ");
                    Integer ammount =sc.nextInt();
                    addProductInBasket(id,ammount);
                    break;
                case "3":
                    seeAllProductsInBasket();
                    break;
                case "4":
                    System.out.println("Order accepted");
                    calculateOrder();
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("wrong flag");
            }

        }
    }

    public void seeAllProducts(){
        for (Product product : setAllProducts) {
            System.out.println(product);
        }
    }
    public void seeAllProductsInBasket(){
        for (Product product : productsINBasket.keySet()) {
            System.out.println(product.getNameOfProduct()+" ammount  "+productsINBasket.get(product));
        }
    }

    private void addProductInBasket(Integer id,Integer amount){
        for (Product product : setAllProducts) {
            if(product.getId()==id){
                if(productsINBasket.containsKey(product)){
                    productsINBasket.put(product,productsINBasket.get(product)+amount);
                    return;
                }
                else {
                    productsINBasket.put(product,amount);
                    return;
                }
            }
        }
        System.out.println("wrong id");
    }
    private void calculateOrder(){
        int total=0;
        for (Product product : productsINBasket.keySet()) {
            total+=product.getPrice()*productsINBasket.get(product);
        }
        System.out.println("Total price: "+total);
    }
}
