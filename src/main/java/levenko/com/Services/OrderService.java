package levenko.com.Services;

import levenko.com.DAO.Orders_ProductsDAO;
import levenko.com.Entites.Order;
import levenko.com.DAO.OrderDAO;
import levenko.com.Entites.Product;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();
    public List<Order> getListOrders(){
        return orderDAO.getAllOrders();
    }

    public Order getOrderById(int id){
        return orderDAO.getOrdersByID(id);
    }

    public void insertOrderInDB(Map<Product,Integer> ProductsInOrder){
        int id = orderDAO.insertOrder();
        new Orders_ProductsDAO().insertOrder(id,ProductsInOrder);
    }

    public List<Order> getAllOrdersBetweenDates(Date begin, Date finish){
        return orderDAO.getAllOrdersBetweenDates(begin,finish);
    }
    public Order getOrderWithProductsByID(int id){
        return orderDAO.getOrderWithProductsByID(id);
    }

    public Order findOrderClosebyDate(Date date){
        long time = date.getTime();
        List<Order> listOrders= getListOrders();
        Order order = listOrders.get(0);
        long min=Math.abs(order.getDate().getTime()-time);
        for (Order order1 : listOrders) {
            long dif = Math.abs(order1.getDate().getTime()-time);
            if(dif<min){
                min = dif;
                order=order1;
            }
        }
        return order;

    }

}
