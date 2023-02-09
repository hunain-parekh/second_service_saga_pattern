package com.hunain.second_service.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private Long userId;
    @Setter
    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date order_date;
}
