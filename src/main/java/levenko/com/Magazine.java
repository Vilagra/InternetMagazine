package levenko.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by Vilagra on 28.03.2016.
 */
public class Magazine {


    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        String query = "select * from score";
        Set<Product> listAllProductsWithBD = new HashSet<>();
        try{
            Statement statment = connect.getConnection().createStatement();
            ResultSet resultSet = statment.executeQuery(query);
            while (resultSet.next()){
                Product product = new Product(resultSet.getInt(1),resultSet.getInt(3),resultSet.getString(2));
                listAllProductsWithBD.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Basket first = new Basket(listAllProductsWithBD);
        first.workWithBasket();


    }



}
