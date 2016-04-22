package levenko.com;

import levenko.com.Entites.Basket;
import levenko.com.Entites.Product;
import levenko.com.Services.OrderService;
import levenko.com.Services.ProductService;

import java.util.*;



/**
 * Created by Vilagra on 28.03.2016.
 */
public class Choiser {

    public void workWithBasket(){
        Basket basket = new Basket();
        String flag ="";
        Scanner sc= new Scanner(System.in);
        while(!flag.equals("5")) {
            System.out.println("Welcome in internet shop");
            System.out.println("Press '1' if you want to see list of products");
            System.out.println("Press '2' if you want to add products in basket");
            System.out.println("Press '3' if you want to see what stored in your basket");
            System.out.println("Press '4' if you want to make order");
            System.out.println("Press '5' if you want to close shop");
            System.out.println("Make your choise:");
            flag = sc.next();
            switch(flag){
                case "1":
                    System.out.println(new ProductService().getAllProduct());
                    break;
                case "2":
                    System.out.println("Choice product:");
                    System.out.println(new ProductService().getAllProduct());
                    System.out.print("Enter name of product: ");
                    String name = sc.next();
                    System.out.print("Enter amount: ");
                    Integer ammount =sc.nextInt();
                    Product product = new ProductService().getProductByName(name);
                    if(product!=null) {
                        basket.addProductInBasket(new ProductService().getProductByName(name), ammount);
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
                    OrderCalculate order = new OrderCalculate(basket);
                    System.out.println("Order accepted");
                    System.out.println(order);
                    new OrderService().insertOrderInDB(order.getProductsInBasket());
                    basket.cleanOutBasket();
                    break;
                case "5":
                    System.out.println("Thank you!,Bye!");
                    break;
                default:
                    System.out.println("wrong flag");
            }

        }
    }






}
