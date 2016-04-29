package levenko.com.DAO;

import levenko.com.Entites.Order;
import levenko.com.Entites.Product;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class OrderDAO extends AbstractDao{
    private static final String SQL_GET_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SQL_GET_ORDERS_BY_ID = "SELECT * FROM orders WHERE id=?";
    private static final String SQL_INSERT_ORDER = "INSERT INTO orders VALUES(DEFAULT,?)";
    private static final String SQL_LAST_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_ORDERS_BETWEN_DATES = "SELECT orders.id, orders.date, products.name, products.price, orders_products.product_count " +
                                                        "FROM orders JOIN orders_products ON orders.id=orders_products.order_id " +
                                                        "JOIN products ON orders_products.product_id=products.id "+
                                                        "WHERE orders.date BETWEEN ? AND ? "+
                                                        "ORDER BY orders.id";
    private static final String SQL_ORDER_WITH_PRODUCTS_BY_ID = "SELECT orders.id, orders.date, products.name, products.price, orders_products.product_count " +
            "FROM orders JOIN orders_products ON orders.id=orders_products.order_id " +
            "JOIN products ON orders_products.product_id=products.id "+
            "WHERE orders.id=?";


    public List<Order> getAllOrders() {
        Connection connect = new OrderDAO().getConnection();
        List<Order> listAllOrdersWithBD = new ArrayList<>();
        try (Statement statment = connect.createStatement();
             ResultSet resultSet = statment.executeQuery(SQL_GET_ALL_ORDERS)) {
            while (resultSet.next()) {
                Order order = extractOrder(resultSet);
                listAllOrdersWithBD.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Problem with connectDB");
            System.out.println(e);
        }

        return listAllOrdersWithBD;
    }

    public Order getOrdersByID(int id) {
        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Order order = null;
        try {
            connect = new OrderDAO().getConnection();
            pstmt = connect.prepareStatement(SQL_GET_ORDERS_BY_ID);
            pstmt.setString(1, id + "");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                order = extractOrder(resultSet);
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

        return order;
    }
    //@Return id of the last entry in the table
    public int insertOrder(){
        int last_id = 0;
        try (Connection connection = new OrderDAO().getConnection();PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ORDER)){
            statement.setDate(1,new Date(System.currentTimeMillis()));
            statement.execute();
            ResultSet rs=statement.executeQuery(SQL_LAST_ID);
            rs.next();
            last_id = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error in work DB");
            System.out.println(e);
        }
        return last_id;
    }

    public Order getOrderWithProductsByID(int id){
        Order order = new Order();
        try(Connection connection = new OrderDAO().getConnection();PreparedStatement statement = connection.prepareStatement(SQL_ORDER_WITH_PRODUCTS_BY_ID)) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                if(rs.isFirst()) order = extractOrder(rs);
                Product product = new ProductDAO().getProductByName(rs.getString(3));
                product.setPrice(rs.getInt(4));
                order.addProductWithAmount(product, rs.getInt(5));
            }
        }
            catch (SQLException e){
            System.out.println("Error in work DB5");
            System.out.println(e);
        }
        return order;
    }
    public List<Order> getAllOrdersBetweenDates(Date begin, Date finish){
        List <Order> orderList = new ArrayList<>();
        try(Connection connection = new OrderDAO().getConnection();PreparedStatement statement = connection.prepareStatement(SQL_ORDERS_BETWEN_DATES)) {
            statement.setDate(1, begin);
            statement.setDate(2, finish);
            ResultSet rs = statement.executeQuery();
            int id=0;
            Order order = new Order();
            while(rs.next()){
                if(rs.isFirst()){
                    id=rs.getInt(1);
                    order = extractOrder(rs);
                }
                if(rs.getInt(1)==id){
                    Product product = new ProductDAO().getProductByName(rs.getString(3));
                    product.setPrice(rs.getInt(4));
                    order.addProductWithAmount(product, rs.getInt(5));

                }
                else{
                    orderList.add(order);
                    id=rs.getInt(1);
                    order = extractOrder(rs);
                    Product product = new ProductDAO().getProductByName(rs.getString(3));
                    product.setPrice(rs.getInt(4));
                    order.addProductWithAmount(product, rs.getInt(5));
                }
                if (rs.isLast()) {
                    orderList.add(order);
                }
            }
        }
        catch (SQLException e){
            System.out.println("Error in work DB5");
            System.out.println(e);
        }
        return orderList;
    }



    public Order extractOrder(ResultSet rs) throws SQLException {
        int ID = rs.getInt(1);
        Date date = rs.getDate(2);
        Order order = new Order();
        order.setId(ID);
        order.setDate(date);
        return order;

    }




}
