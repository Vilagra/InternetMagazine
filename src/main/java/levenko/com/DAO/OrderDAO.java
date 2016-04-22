package levenko.com.DAO;

import levenko.com.Entites.Order;

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



    public Order extractOrder(ResultSet rs) throws SQLException {
        int ID = rs.getInt(1);
        Date date = rs.getDate(2);
        Order order = new Order();
        order.setId(ID);
        order.setDate(date);
        return order;

    }


}
