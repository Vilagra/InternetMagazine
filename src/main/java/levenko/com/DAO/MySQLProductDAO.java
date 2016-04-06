package levenko.com.DAO;

import levenko.com.Entites.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vilagra on 05.04.2016.
 */
public class MySQLProductDAO {
    private static final String SQL_FIND_PRODUCTS = "SELECT * FROM score";
    private static final String SQL_FIND_PRODUCT_BY_ID = "SELECT * FROM score WHERE id=?";
    private static final String SQL_FIND_PRODUCT_BY_NAME = "SELECT * FROM score WHERE Product=?";



    public List<Product> getAllProducts() {
        DBConnect connect = new DBConnect();
        List<Product> listAllProductsWithBD = new ArrayList<>();
        try (Statement statment = connect.getConnection().createStatement();
            ResultSet resultSet = statment.executeQuery(SQL_FIND_PRODUCTS)){
            while (resultSet.next()) {
                Product product = new Product(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2));
                listAllProductsWithBD.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAllProductsWithBD;
    }

    public Product getProductByID(int id) {
        DBConnect connect = new DBConnect();
        Product product = null;
        try {
            PreparedStatement pstmt = connect.getConnection().prepareStatement(SQL_FIND_PRODUCT_BY_ID);
            pstmt.setString(1, id + "");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                product = new Product(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2));
            }
            pstmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public Product getProductByName(String name) {
        DBConnect connect = new DBConnect();
        Product product = null;
        try {
            PreparedStatement pstmt = connect.getConnection().prepareStatement(SQL_FIND_PRODUCT_BY_NAME);
            pstmt.setString(1, name);
            System.out.println(pstmt);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                product = new Product(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2));
            }
            pstmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


}
