package levenko.com.Services;

import levenko.com.DAO.ProductDAO;
import levenko.com.Entites.Product;

import java.util.List;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(){
        productDAO = new ProductDAO();
    }

    public List<Product> getAllProduct(){
        return productDAO.getAllProducts();
    }

    public Product getProductByID(int ID){
        return productDAO.getProductByID(ID);
    }

    public Product getProductByName(String name){
        return productDAO.getProductByName(name);
    }

    public Product getProductWithMisspelling(String name){
        Product product = null;
        List<Product> listAllProduct = getAllProduct();
        for (Product product1 : listAllProduct) {
            String name1 = product1.getName();
            int count = 0;
            for (int i = 0; i < name1.length(); i++) {
                if(name.charAt(i)!=name1.charAt(i)){
                    count++;
                }
                if(count>1) break;
            }
            if(count==1){
                return product1;
            }
        }
        return product;
    }
}
