package upao.edu.pe.apidelivery.service;

import org.springframework.stereotype.Service;
import upao.edu.pe.apidelivery.entities.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> listOrders;

    public OrderService(){
        this.listOrders = new ArrayList<>();
    }

    public Order findOrderById(int id){
       return (Order)this.listOrders.stream().filter((order) -> {
           return id == (order.getId());
       }).findFirst().orElse(null);
    }

    public String getOrderStatus(int id){
        Order order = this.findOrderById(id);
        if(order != null){
            return order.getStatus();
        }else {
            throw new RuntimeException("Pedido no encontrado");
        }
    }

    public List<Order> getAllOrders() {
        return this.listOrders;
    }
}
