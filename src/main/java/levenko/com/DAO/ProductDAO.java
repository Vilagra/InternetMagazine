package levenko.com.DAO;

import levenko.com.Entites.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vilagra on 05.04.2016.
 */
public class ProductDAO extends AbstractDao {
    private static final String SQL_FIND_PRODUCTS = "SELECT * FROM products";
    private static final String SQL_FIND_PRODUCT_BY_ID = "SELECT * FROM products WHERE id=?";
    private static final String SQL_FIND_PRODUCT_BY_NAME = "SELECT * FROM products WHERE name=?";


    public List<Product> getAllProducts() {
        Connection connect = new ProductDAO().getConnection();
        List<Product> listAllProductsWithBD = new ArrayList<>();
        try (Statement statment = connect.createStatement();
             ResultSet resultSet = statment.executeQuery(SQL_FIND_PRODUCTS)) {
            while (resultSet.next()) {
                Product product = extractProduct(resultSet);
                listAllProductsWithBD.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Problem with connectDB");
            System.out.println(e);
        }
        return listAllProductsWithBD;
    }

    public Product getProductByID(int id) {
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connect = new ProductDAO().getConnection();
            pstmt = connect.prepareStatement(SQL_FIND_PRODUCT_BY_ID);
            pstmt.setString(1, id + "");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                product = extractProduct(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Problem with connectDB");
            System.out.println(e);
        }
        finally {
            try {
                pstmt.close();
                resultSet.close();
                connect.close();
            } catch (SQLException e) {
                System.out.println("Problem with closeDB");
                System.out.println(e);
            }
        }

        return product;
    }

    public Product getProductByName(String name) {
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connect = new ProductDAO().getConnection();
            pstmt = connect.prepareStatement(SQL_FIND_PRODUCT_BY_NAME);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                product = extractProduct(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Problem with connectDB");
            System.out.println(e);
        }
        finally {
            try {
                pstmt.close();
                resultSet.close();
                connect.close();
            } catch (SQLException e) {
                System.out.println("Problem with closeDB");
                System.out.println(e);
            }
        }

        return product;

    }

    private Product extractProduct(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        int price = rs.getInt(3);
        String name = rs.getString(2);
        return new Product(id,price,name);

    }

}
