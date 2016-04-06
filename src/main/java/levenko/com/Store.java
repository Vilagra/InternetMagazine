package levenko.com;

import levenko.com.DAO.MySQLProductDAO;
import levenko.com.Entites.Product;

import java.util.List;

/**
 * Created by Vilagra on 06.04.2016.
 */
public class Store {
    private MySQLProductDAO productDAO = new MySQLProductDAO();
    private List<Product> ListAllProducts = productDAO.getAllProducts();

    public void seeAllProducts(){
        for (Product product : ListAllProducts) {
            System.out.println(product);
        }
    }

    public Product getProductByID(int id){
        return productDAO.getProductByID(id);

    }

    public Product getProductByName(String name){
        return productDAO.getProductByName(name);
    }
}
