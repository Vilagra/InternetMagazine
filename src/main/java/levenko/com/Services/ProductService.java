package levenko.com.Services;

import levenko.com.DAO.MySQLProductDAO;
import levenko.com.Entites.Product;

import java.util.List;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class ProductService {

    public List<Product> getAllProduct(){
        return new MySQLProductDAO().getAllProducts();
    }

    public Product getProductByID(int ID){
        return new MySQLProductDAO().getProductByID(ID);
    }

    public Product getProductByName(String name){
        return new MySQLProductDAO().getProductByName(name);
    }
}
