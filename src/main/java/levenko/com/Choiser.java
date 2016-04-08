package levenko.com;

import levenko.com.Entites.Basket;
import levenko.com.Entites.Product;

import java.util.*;

/**
 * Created by Vilagra on 28.03.2016.
 */
public class Choiser {

    public void workWithBasket(){
        Basket basket = new Basket();
        Store store = new Store();
        String flag ="";
        Scanner sc= new Scanner(System.in);
        while(!flag.equals("4")) {
            System.out.println("Welcome in internet shop");
            System.out.println("Press '1' if you want to see list of products");
            System.out.println("Press '2' if you want to add products in basket");
            System.out.println("Press '3' if you want to see what stored in your basket");
            System.out.println("Press '4' if you want to make order");
            System.out.println("Make your choise:");
            flag = sc.next();
            switch(flag){
                case "1":
                    store.seeAllProducts();
                    break;
                case "2":
                    System.out.println("Choice product:");
                    store.seeAllProducts();
                    System.out.print("Enter name of product: ");
                    String name = sc.next();
                    System.out.print("Enter amount: ");
                    Integer ammount =sc.nextInt();
                    Product product = store.getProductByName(name);
                    if(product!=null) {
                        basket.addProductInBasket(store.getProductByName(name), ammount);
                    }
                    else{
                        System.out.println("incorrect name");
                    }
                    System.out.println();
                    break;
                case "3":
                    basket.seeAllProductsInBasket();
                    System.out.println();
                    break;
                case "4":
                    Order order = new Order(basket);
                    System.out.println("Order accepted");
                    System.out.println(order);
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("wrong flag");
            }

        }
    }






}
