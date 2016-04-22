package levenko.com.Services;

import levenko.com.DAO.Orders_ProductsDAO;
import levenko.com.Entites.Order;
import levenko.com.DAO.OrderDAO;
import levenko.com.Entites.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Vilagra on 19.04.2016.
 */
public class OrderService {

    public List<Order> getListOrders(){
        return new OrderDAO().getAllOrders();
    }

    public Order getOrderById(int id){
        return new OrderDAO().getOrdersByID(id);
    }

    public void insertOrderInDB(Map<Product,Integer> ProductsInOrder){
        OrderDAO orderDAO = new OrderDAO();
        int id = orderDAO.insertOrder();
        new Orders_ProductsDAO().insertOrder(id,ProductsInOrder);
    }
}
