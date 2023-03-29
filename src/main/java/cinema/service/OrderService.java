package cinema.service;

import cinema.model.Order;
import cinema.model.User;
import cinema.model.ShoppingCart;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
