package levenko.com.DAO;

import levenko.com.Entites.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Vilagra on 21.04.2016.
 */
public class Orders_ProductsDAO extends AbstractDao{
    private static final String SQL_INSERT_ORDER = "INSERT INTO orders_products VALUES(?,?,?)";

    public void insertOrder(int id, Map<Product,Integer> ProductsInOrder){
        try(Connection connection = new OrderDAO().getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ORDER)){
            for (Product product : ProductsInOrder.keySet()) {
                statement.setInt(1,id);
                statement.setInt(2,product.getId());
                statement.setInt(3,ProductsInOrder.get(product));
                statement.execute();
            }
        }
        catch(SQLException e){
            System.out.println("Incoorect work DB");
            System.out.println(e);
        }
    }
}
