package upao.edu.pe.apidelivery.entities;

import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private String customerEmail;
    private String status;
    private LocalDateTime createdTime;
    private Duration estimatedDeliveryTime;
    private List<Food> items;

    public Order(String customerName, String customerEmail){
        this.id = id++;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.status = "en progreso";
        this.createdTime = LocalDateTime.now();
        this.estimatedDeliveryTime = Duration.ofMinutes(30);
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Duration getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(Duration estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public List<Food> getItems() {
        return items;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }
}
