package com.example.foodorder.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime orderDate;

    private Integer estimatedTime;

    private boolean deliveredFinish;

    private Long shopId;

    @OneToMany(mappedBy = "orders", cascade = ALL, orphanRemoval = true)
    private List<OrderFood> foodList = new ArrayList<>();


    public Orders(String address, LocalDateTime orderDate, Long shopId) {
        this.address = address;
        this.orderDate = orderDate;
        this.estimatedTime = -1;
        this.deliveredFinish = false;
        this.shopId = shopId;
    }


    public void addOrderFood(OrderFood orderFood) {
        foodList.add(orderFood);
        orderFood.addOrders(this);
    }

    public static Orders of(String address, LocalDateTime orderDate, Long shopId) {
        return new Orders(address, orderDate, shopId);
    }

    public void changeEstTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
