package upao.edu.pe.apidelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.pe.apidelivery.entities.Food;
import upao.edu.pe.apidelivery.entities.Order;
import upao.edu.pe.apidelivery.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/delivery")
public class OrderController {
    private List<Food> menu = new ArrayList<>();

    @Autowired
    private OrderService orderService;

    public OrderController() {
        this.menu.add(new Food("Lomo Saltado", "Elaborado con lomo fino", 29.99));
        this.menu.add(new Food("Tallarines Verdes", "Deliciosa Pasta", 19.99));
        this.menu.add(new Food("Bisteck a lo pobre", "Elaborado con la mejor calidad", 39.99));
    }

    @GetMapping("/menu")
    public  List<Food> getMenu(){
        return this.menu;
    }

    @PostMapping("/createOrder")
    public Order createOrder(Order order){
        return this.orderService.createOrder(order);
    }
    @GetMapping("/orderID/status")
    public String getOrderStatus(@PathVariable int orderId){
        return this.orderService.getOrderStatus(orderId);
    }

    @GetMapping("/allorder")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(int id,Order order){
        Order orderNew = this.orderService.findOrderById(id);
        if(orderNew == null){
            return ResponseEntity.notFound().build();
        }else{
            orderNew.setStatus(order.getStatus());
            return ResponseEntity.ok().body(orderNew);
        }
    }
}
