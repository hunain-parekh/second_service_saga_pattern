package com.hunain.second_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunain.second_service.Model.Order;

public interface IOrderRepository extends JpaRepository<Order,Long>{

    public List<Order> findAllByUserId(Long user_id);
}
