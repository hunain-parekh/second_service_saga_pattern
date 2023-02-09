package com.hunain.second_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunain.second_service.Model.Order;
import com.hunain.second_service.Repository.IOrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderRepository orderRepo;
    
    @PostMapping
    public void saveOrder(@RequestBody Order Order){
        this.orderRepo.save(Order);
    }

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return this.orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return this.orderRepo.findById(id).orElse(null);
    }

    @PutMapping
    public void updateOrder(@RequestBody Order Order){
        this.orderRepo.save(Order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        this.orderRepo.deleteById(id);
    }

    @DeleteMapping("all/{userId}")
    public void deleteOrdersByUserId(@PathVariable Long userId){
       List<Order> orders =  this.orderRepo.findAllByUserId(userId);
       orders.forEach(order -> this.orderRepo.delete(order));
    }
}
